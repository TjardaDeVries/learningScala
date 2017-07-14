package movies

case class Film(name: String,
  yearOfRelease: Int,
  imdbRating: Double,
  director: Director) {

  def directorsAge: Int = yearOfRelease - director.yearOfBirth
  def isDirectedBy(d: Director): Boolean = this.director == d
}

object Film {

  def highestRating(film1: Film, film2: Film): Double = {
    val rating1 = film1.imdbRating
    val rating2 = film2.imdbRating
    if (rating1 > rating2) rating1 else rating2
  }

  def oldestDirectorAtTheTime(film1: Film, film2: Film): Director =
    if (film1.directorsAge > film2.directorsAge)
      film1.director
    else
      film2.director
}
