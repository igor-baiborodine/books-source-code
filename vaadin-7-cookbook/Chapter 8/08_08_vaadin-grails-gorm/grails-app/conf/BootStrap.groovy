import vaadin.grails.gorm.User

class BootStrap {

    def init = { servletContext ->
        environments {
            development {
                User user1 = new User()
                user1.name = "Sara"
                user1.save(failOnError: true)

                User user2 = new User()
                user2.name = "Ester"
                user2.save(failOnError: true)
            }
        }
    }
    def destroy = {
    }
}
