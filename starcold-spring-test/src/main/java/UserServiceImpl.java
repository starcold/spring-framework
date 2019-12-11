public class UserServiceImpl implements IUserService{
	public UserServiceImpl(){
		System.out.println("创建Bean");
	}

	public String getUser(){
		return "starcold";
	}
}