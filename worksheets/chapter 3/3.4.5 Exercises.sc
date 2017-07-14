import counting.Counter

Counter(0) // construct objects without `new`
Counter().inc // printout shows the value of `count`
Counter().inc.dec == Counter().dec.inc // semantic equality check


