var globalValue: Int = 0

def ro(x: Int) = {
  globalValue = globalValue + 1
  x + globalValue
}

def rt(x: Int) = {
  x + 1
}

rt(5)
rt(5)
ro(5)
ro(5)


print(5)