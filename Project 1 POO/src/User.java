
public abstract class User implements Register{

		private String name;
		private String password;
		private int type;
		
		public User(String name, String password, int type) {
			super();
			this.name = name;
			this.password = password;
			this.type = type;
		}
		
}
