import com.java7developer.chapter13.PlayerCharacter

class BootStrap {

  def init = { servletContext ->
    if (!PlayerCharacter.count()) {
      new PlayerCharacter(strength: 3, dexterity: 5, charisma: 18)
                                    .save(failOnError: true)
      new PlayerCharacter(strength: 18, dexterity: 10, charisma: 4)
                                    .save(failOnError: true)
      }
  }

  def destroy = {}
}
