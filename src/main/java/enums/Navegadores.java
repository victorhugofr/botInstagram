package enums;

public enum Navegadores {
	
	PADRAO{
		@Override
		public String getNavegador() {
			return "firefox";
		}
	},
	
	FIREFOX{
		@Override
		public String getNavegador() {
			return "firefox";
		}
	},
	CHROME{
		@Override
		public String getNavegador() {
			return "chrome";
		}
	}, IE{
		@Override
		public String getNavegador() {
			return "internet-explorer";
		}
	}, EDGE{
		@Override
		public String getNavegador() {
			return "edge";
		}
	},
	PHANTON_JS{
		@Override
		public String getNavegador() {
			return "phantonjs";
		}
	};
	
	public abstract String getNavegador();
	

}
