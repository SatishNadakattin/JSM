package com.app.exception;

import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.http.HttpStatus;
import static org.apache.http.HttpStatus.SC_OK;

public class BankRestException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5253948659616988590L;
	
	public static int INTERNAL_ERROR_CODE = -1;
	protected int httpErrorCode = SC_OK;
	protected int errorCode = Integer.MAX_VALUE;
	protected String exReason;
	protected Map<String, Object> meta;
	protected Map<String, String> dictionary;

	public BankRestException(int i, HttpStatus internalServerError, String string) {
		super();
		this.meta = new LinkedHashMap<String, Object>();
	}

	public BankRestException(String message) {
		super(message);
		this.meta = new LinkedHashMap<String, Object>();
	}

	public BankRestException(String message, Throwable t) {
		super(message, t);
		this.meta = new LinkedHashMap<String, Object>();
	}

	public BankRestException(String message, Throwable t, int errCode) {
		this(message, t);
		errorCode = errCode;
	}

	public BankRestException(String message, Throwable t, int errCode, int httpErrCode) {
		this(message, t);
		errorCode = errCode;
		httpErrorCode = httpErrCode;
	}

	public BankRestException(int errCode, int httpErrCode, String message) {
		this(message);
		errorCode = errCode;
		httpErrorCode = httpErrCode;
	}

	public BankRestException(int errCode, int httpErrCode, String message, Throwable t) {
		this(message, t);
		errorCode = errCode;
		httpErrorCode = httpErrCode;
	}

	public String getExReason() {
		return exReason;
	}

	public void setExReason(String exReason) {
		this.exReason = exReason;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public int getHttpErrorCode() {
		return httpErrorCode;
	}

	public void setHttpErrorCode(int httpErrorCode) {
		this.httpErrorCode = httpErrorCode;
	}

	public Map<String, Object> getMeta() {
		return meta;
	}

	public void setMeta(Map<String, Object> meta) {
		this.meta = meta;
	}

	public Map<String, String> getDictionary() {
		return dictionary;
	}

	public void setDictionary(Map<String, String> dictionary) {
		this.dictionary = dictionary;
	}
	
	
	/**
	 * Common Exceptions
	 * Error code range - 1000 to 1100
	 */
	
	public static final class BACKEND_SERVER_ERROR extends BankRestException {
		private static final long serialVersionUID = 1L;

		public BACKEND_SERVER_ERROR() {
			super(1000, HttpStatus.SC_INTERNAL_SERVER_ERROR, String.format("Backend Server Error, Please Retry."));
		}
	}

	public static final class BACKEND_SERVER_READ_TIMEOUT extends BankRestException {
		private static final long serialVersionUID = 1L;

		public BACKEND_SERVER_READ_TIMEOUT() {
			super(1001, HttpStatus.SC_GATEWAY_TIMEOUT,
					String.format("Backend Server read timeout Error, Please Retry."));
		}
	}

	public static final class ACCESS_DENIED extends BankRestException {
		private static final long serialVersionUID = 1L;

		public ACCESS_DENIED() {
			super(1002, HttpStatus.SC_UNAUTHORIZED, String.format("Access denied Error"));
		}
	}

	public static final class FORBIDDEN extends BankRestException {
		private static final long serialVersionUID = 1L;

		public FORBIDDEN() {
			super(1003, HttpStatus.SC_FORBIDDEN, String.format("Forbidden Error"));
		}
	}

	public static final class SC_NOT_FOUND extends BankRestException {
		private static final long serialVersionUID = 1L;

		public SC_NOT_FOUND() {
			super(1004, HttpStatus.SC_NOT_FOUND, String.format("Not Found"));
		}
	}

	public static final class BACKEND_PARSE_ERROR extends BankRestException {
		private static final long serialVersionUID = 1L;

		public BACKEND_PARSE_ERROR() {
			super(1005, HttpStatus.SC_INTERNAL_SERVER_ERROR, String.format("Backend parse Error"));
		}
	}
	public static final class SAVE_FAILED extends BankRestException {
		private static final long serialVersionUID = 1L;

		public SAVE_FAILED(String message) {
			super(1006, HttpStatus.SC_NOT_FOUND,message);
		}
	}
	public static final class UPDATE_FAILED extends BankRestException {
		private static final long serialVersionUID = 1L;

		public UPDATE_FAILED(String message) {
			super(1007, HttpStatus.SC_NOT_FOUND,message);
		}
	}
	public static final class DELETE_FAILED extends BankRestException {
		private static final long serialVersionUID = 1L;

		public DELETE_FAILED(String message) {
			super(1008, HttpStatus.SC_NOT_FOUND,message);
		}
	}

	public static final class NOT_FOUND extends BankRestException {
		private static final long serialVersionUID = 1L;

		public NOT_FOUND(String message) {
			super(1009, HttpStatus.SC_NOT_FOUND, message);
		}
	}
	
	public static final class COUNT_NOT_FOUND extends BankRestException {
		private static final long serialVersionUID = 1L;

		public COUNT_NOT_FOUND(String message) {
			super(1010, HttpStatus.SC_NOT_FOUND, message);
		}
	}
	public static final class DUPLICATE_KEY extends BankRestException {
		private static final long serialVersionUID = 1L;

		public DUPLICATE_KEY(String message) {
			super(1011, HttpStatus.SC_NOT_FOUND, message);
		}
	}
}