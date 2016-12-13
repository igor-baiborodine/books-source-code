class StringUtils
{
  static String sayHello(String name)
  {
    if (name ==  "Martijn" || name == "Ben")
      "Hello author " + name + "!"
    else
      "Hello reader " + name + "!"
  }
}

println StringUtils.sayHello("Bob");