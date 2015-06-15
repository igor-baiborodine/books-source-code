import vaadin.grails.services.User

class BootStrap {

    def init = { servletContext ->
        environments {
            development {
                User user1 = new User(name: "Anna")
                user1.save(failOnError: true)

                User user2 = new User(name: "Mia")
                user2.save(failOnError: true)
            }
        }
    }
    def destroy = {
    }
}
