Integer x = new Integer(2);
Integer y = new Integer(2);
Integer z = null;

if (x == y)
{
  println "x == y"
}

if (!x.is(y))
{
  println "x is not y"
}

if (z.is(null))
{
  println "z is null"
}

if (z == null)
{
  println "z is null"
}