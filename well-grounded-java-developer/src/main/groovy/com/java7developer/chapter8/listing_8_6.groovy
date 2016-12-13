def sayHello =
{
  name ->
    if (name == "Martijn" || name == "Ben") 
      "Hello author " + name + "!" 
    else
      "Hello reader " + name + "!" 
}

println(sayHello("Martijn"))