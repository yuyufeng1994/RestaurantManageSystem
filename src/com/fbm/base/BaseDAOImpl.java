package com.fbm.base;

import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;



import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.fbm.util.JDBCUtils;
import com.fbm.util.ReflectionUtils;
import com.fbm.web.ConnectionContext;

@SuppressWarnings("unchecked")
public class BaseDAOImpl<T> implements BaseDAO<T> {
	private QueryRunner queryRunner = new QueryRunner();

	private Class<T> clazz;

	public BaseDAOImpl() {
		// clazz = ReflectionUtils.getSuperGenericType(getClass());
		// 使用反射技术得到T的真实类型
		ParameterizedType parameterizedType = (ParameterizedType) this
				.getClass().getGenericSuperclass();// 获取当前new对象的泛型的父类类型
		this.clazz = (Class<T>) parameterizedType.getActualTypeArguments()[0];// 获取第一个类型参数的真实类型
	}

	@Override
	public long insert(String sql, Object... args) {

		long id = 0;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = ConnectionContext.getInstance().get();
			preparedStatement = connection.prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);

			if (args != null) {
				for (int i = 0; i < args.length; i++) {
					preparedStatement.setObject(i + 1, args[i]);
				}
			}

			preparedStatement.executeUpdate();

			resultSet = preparedStatement.getGeneratedKeys();
			if (resultSet.next()) {
				id = resultSet.getLong(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//JDBCUtils.releaseSource(null, null, connection);
			JDBCUtils.release(resultSet, preparedStatement);
		}

		return id;
	}

	@Override
	public void update(String sql, Object... args) {
		Connection connection = null;
		
		try {
			connection = ConnectionContext.getInstance().get();
			queryRunner.update(connection, sql, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public T query(String sql, Object... args) {
		
		Connection connection = null;
		
		try {
			connection = ConnectionContext.getInstance().get();
			return queryRunner.query(connection, sql, new BeanHandler<T>(clazz), args);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}


	@Override
	public List<T> queryForList(String sql, Object... args) {
		Connection connection = null;
		
		try {
			connection = ConnectionContext.getInstance().get();
			return queryRunner.query(connection, sql, new BeanListHandler<T>(clazz), args);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
	@Override
	public <V> V getSingleVal(String sql, Object... args) {
		Connection connection = null;
		
		try {
			connection = ConnectionContext.getInstance().get();
			return (V)queryRunner.query(connection, sql, new ScalarHandler(), args);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}


	@Override
	public void batch(String sql, Object[]... params) {
		Connection connection = null;
		
		try {
			connection = ConnectionContext.getInstance().get();
			queryRunner.batch(connection, sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
