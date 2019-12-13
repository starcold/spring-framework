public class UserServiceImpl implements IUserService{
	private IUserDao userDao;

	public UserServiceImpl(){
		System.out.println("创建Bean");
	}

	public String getUser(){
		return "starcold";
	}

	public IUserDao getUserDao() {
		return userDao;
	}

	public void  setUserDao(IUserDao userDao) {
		 this.userDao = userDao;
	}
}