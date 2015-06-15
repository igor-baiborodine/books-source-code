package vaadin.grails.services

class UserService {

    List<User> getAll() {
        List<User> list = User.list()
        return list
    }
	
	User add(String name) {
		User user = new User(name: name)
		user.save(failOnError:true)
		return user
	}
}
