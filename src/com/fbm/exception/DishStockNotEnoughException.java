package com.fbm.exception;

public class DishStockNotEnoughException extends Exception {

	/**
	 * 库存不足异常
	 */
	private static final long serialVersionUID = 1L;

	public DishStockNotEnoughException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DishStockNotEnoughException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DishStockNotEnoughException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public DishStockNotEnoughException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "库存不足";
	}
	

}
