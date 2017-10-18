package com.fbm.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fbm.util.JDBCUtils;
import com.fbm.web.ConnectionContext;

/**
 * 对所有的数据库操作采用事务操作
 * Servlet Filter implementation class TranactionFilter
 */
public class TranactionFilter implements Filter {

    /**
     * Default constructor. 
     */
    public TranactionFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		Connection connection = null;
		
		try {
			
			//1. ��ȡ����
			connection = JDBCUtils.getConnection();
			
			//2. ��������
			connection.setAutoCommit(false);
			
			//3. ���� ThreadLocal �����Ӻ͵�ǰ�̰߳�
			ConnectionContext.getInstance().bind(connection);
			
			//4. ������ת��Ŀ�� Servlet
			chain.doFilter(request, response);
			
			//5. �ύ����
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			
			//6. �ع�����
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			HttpServletResponse resp = (HttpServletResponse) response;
			HttpServletRequest req = (HttpServletRequest) request;
			resp.sendRedirect(req.getContextPath() + "/error.jsp");
			
		} finally{
			//7. ����
			ConnectionContext.getInstance().remove();
			
			//8. �ر�����
			JDBCUtils.release(connection);
			
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
