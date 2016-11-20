package util;

public enum ResultMessage {
	SUCCESS, FAIL, EXISTED;
	public ResultMessage getResultMessage(String meg) {
		switch (meg) {
		case "SUCCESS":
			return SUCCESS;
		case "FAIL":
			return FAIL;
		case "EXISTED":
			return EXISTED;
		default:
			return null;
		}
	}
}