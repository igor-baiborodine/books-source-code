class Character
{
  private int strength
  private int wisdom
}
 
def pc = new Character(strength: 10, wisdom: 15)
pc.strength = 18
println "STR [" + pc.strength + "], WIS [" + pc.wisdom + "]"