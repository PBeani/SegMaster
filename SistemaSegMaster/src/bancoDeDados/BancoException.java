package bancoDeDados;

public class BancoException extends Exception {

	private static final long serialVersionUID = 1L;

	public BancoException() {
		super();
	}

	public BancoException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BancoException(String message, Throwable cause) {
		super(message, cause);
	}

	public BancoException(String message) {
		super(message);
	}

	public BancoException(Throwable cause) {
		super(cause);
	}
}
