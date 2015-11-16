package demo;

public enum Action {

	INSERT("i", "insert"), UPDATE("u", "update"), DELETE("d", "delete");

	private final String code;
	private final String value;

	Action(final String code, final String value) {
		this.code = code;
		this.value = value;
	}

	public String getCode() {
		return code;
	}

	public String getValue() {
		return value;
	}

	public static String translate(String cd) {

		String result = null;

		for (Action action : Action.values()) {
			if (action.code.equalsIgnoreCase(cd)) {
				result = action.value;
			}
			continue;
		}
		return result;
	}

}
