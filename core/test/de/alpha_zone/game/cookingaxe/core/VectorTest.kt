@file:Suppress("JAVA_MODULE_DOES_NOT_DEPEND_ON_MODULE")

package de.alpha_zone.game.cookingaxe.core

import de.alpha_zone.game.cookingaxe.universe.Vector2d
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.closeTo
import org.hamcrest.Matchers.contains
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import kotlin.math.sqrt
import de.alpha_zone.game.cookingaxe.core.KVector2d as Vector

class VectorTest {

	@Test
	fun `a vector can be created using x and y coordinates using numbers`() {
		val x: Number = 1.337
		val y: Number = 1337
		val vector = Vector(x, y)

		assertThat(vector.x, `is`(x.toDouble()))
		assertThat(vector.y, `is`(y.toDouble()))
	}

	@Test
	fun `a vector can be created using another vector`() {
		val x: Number = 1.337
		val y: Number = 1337
		val toCopy: Vector2d = TestVector(x, y)
		val vector: Vector2d = Vector(toCopy)

		assertThat(vector.x, `is`(x.toDouble()))
		assertThat(vector.y, `is`(y.toDouble()))
	}

	@Test
	fun `a vector is equal to itself`() {
		val vector = Vector(1, 1)

		assertThat(vector == vector, `is`(true))
	}

	@Test
	fun `vector(1,1) is equal to vector(1,1)`() {
		assertThat(Vector(1, 1) == Vector(1, 1), `is`(true))
	}

	@ParameterizedTest
	@CsvSource("0,0", "1,1", "-1,-1", "0.1,-0.1", "2.5,2.5", "1337,1337")
	fun `a vector is equal if components match`(x: Double, y: Double) {
		assertThat(Vector(x, y) == Vector(x, y), `is`(true))
	}

	@Test
	fun `vector(0,0) + vector(1,1) is vector(1,1)`() {
		assertThat(Vector(0, 0) + Vector(1, 1), `is`(Vector(1, 1)))
	}

	@ParameterizedTest
	@CsvSource("0,0,0,0", "1,0,1,0", "1,1,1,1", "1.5,0.3,33,1", "1337,-1337,99,77")
	fun `vector addition means adding the components`(x1: Double, y1: Double, x2: Double, y2: Double) {
		val added = Vector(x1, y1) + Vector(x2, y2)
		assertThat(added.x, `is`(x1 + x2))
		assertThat(added.y, `is`(y1 + y2))
	}

	@Test
	fun `vector(0,0) += vector(1,1) is vector(1,1)`() {
		val vector = Vector(0, 0)
		vector += Vector(1, 1)
		assertThat(vector, `is`(Vector(1, 1)))
	}

	@ParameterizedTest
	@CsvSource("0,0,0,0", "1,0,1,0", "1,1,1,1")
	fun `vector addition with assigning means adding the components`(x1: Double, y1: Double, x2: Double, y2: Double) {
		val vector = Vector(x1, y1)
		vector += Vector(x2, y2)
		assertThat(vector.x, `is`(x1 + x2))
		assertThat(vector.y, `is`(y1 + y2))
	}

	@Test
	fun `vector(0,0) - vector(1,1) is vector(-1,-1)`() {
		assertThat(Vector(0, 0) - Vector(1, 1), `is`(Vector(-1, -1)))
	}

	@Test
	fun `vector(0,0) -= vector(1,1) is vector(-1,-1)`() {
		val vector = Vector(0, 0)
		vector -= Vector(1, 1)
		assertThat(vector, `is`(Vector(-1, -1)))
	}

	@ParameterizedTest
	@CsvSource("1336, 1336, 1, 1", "1.336, 13.36, 0.001, 0.01")
	fun `vector subtraction means subtracting the components`(x1: Double, y1: Double, x2: Double, y2: Double) {
		val subtracted = Vector(x1, y1) - Vector(x2, y2)
		assertThat(subtracted.x, `is`(x1 - x2))
		assertThat(subtracted.y, `is`(y1 - y2))
	}

	@ParameterizedTest
	@CsvSource("1336, 1336, 1, 1", "1.336, 13.36, 0.001, 0.01")
	fun `vector subtraction with assigning means subtracting the components`(x1: Double, y1: Double, x2: Double, y2: Double) {
		val vector = Vector(x1, y1)
		vector -= Vector(x2, y2)
		assertThat(vector.x, `is`(x1 - x2))
		assertThat(vector.y, `is`(y1 - y2))
	}

	@Test
	fun `negative vector(0,0) is vector(0,0)`() {
		assertThat(-Vector(0, 0), `is`(Vector(0, 0)))
	}

	@Test
	fun `negative vector(1,1) is vector(-1,-1)`() {
		assertThat(-Vector(1, 1), `is`(Vector(-1, -1)))
	}

	@ParameterizedTest
	@CsvSource("13.37,0.1337", "1337,1337", "13.37,1337")
	fun `negative sign on a vector is vector with flipped signs on its components`(x: Double, y: Double) {
		assertThat(-Vector(x, y), `is`(Vector(-x, -y)))
	}

	@Test
	fun `vector(1,1) multiplied with 2 is vector(2,2)`() {
		assertThat(Vector(1, 1) * 2, `is`(Vector(2, 2)))
	}

	@ParameterizedTest
	@ValueSource(doubles = [0.0, 0.5, 1.0, 2.0, 2.5, 3.0])
	fun `vector scalar multiplication results in a new vector by multiplying its components`(scalar: Double) {
		val vector = Vector(1, 1)
		val scaled = vector * scalar
		assertThat(vector.x, `is`(1.0))
		assertThat(vector.y, `is`(1.0))

		assertThat(scaled.x, `is`(scalar))
		assertThat(scaled.y, `is`(scalar))
	}

	@Test
	fun `vector(1,1) multiplied with 2 on assigning changes the vector to vector(2,2)`() {
		val vector = Vector(1, 1)
		vector *= 2
		assertThat(vector, `is`(Vector(2, 2)))
	}

	@ParameterizedTest
	@ValueSource(doubles = [0.0, 0.5, 1.0, 2.0, 2.5, 3.0])
	fun `vector scalar multiplication with assigning is multiplying its components`(factor: Double) {
		val vector = Vector(1, 1)
		vector *= factor
		assertThat(vector.x, `is`(factor))
		assertThat(vector.y, `is`(factor))
	}

	@Test
	fun `vector(1,1) multiplied with Vector(2, 2) is vector(2,2)`() {
		assertThat(Vector(1, 1) * Vector(2, 2), `is`(Vector(2, 2)))
	}

	@ParameterizedTest
	@CsvSource("1336, 1336, 77, 77", "1.336, 13.36, 0.001, 0.01")
	fun `vector multiplication means multiplying the components`(x1: Double, y1: Double, x2: Double, y2: Double) {
		val vector = Vector(x1, y1)
		val product = vector * Vector(x2, y2)

		assertThat(vector.x, `is`(x1))
		assertThat(vector.y, `is`(y1))

		assertThat(product.x, `is`(x1 * x2))
		assertThat(product.y, `is`(y1 * y2))
	}

	@Test
	fun `vector(1,1) multiplied with vector(2, 2) on assigning changes the vector to vector(2,2)`() {
		val vector = Vector(1, 1)
		vector *= Vector(2, 2)
		assertThat(vector, `is`(Vector(2, 2)))
	}

	@ParameterizedTest
	@CsvSource("1336, 1336, 77, 77", "1.336, 13.36, 0.001, 0.01")
	fun `vector multiplication on assign means multiplying its components`(x1: Double, y1: Double, x2: Double, y2: Double) {
		val product = Vector(x1, y1)
		product *= Vector(x2, y2)
		assertThat(product.x, `is`(x1 * x2))
		assertThat(product.y, `is`(y1 * y2))
	}

	@Test
	fun `vector(2,2) divided by 2 is vector(1,1)`() {
		assertThat(Vector(2, 2) / 2, `is`(Vector(1, 1)))
	}

	@ParameterizedTest
	@ValueSource(doubles = [0.0, 0.5, 1.0, 2.0, 2.5, 3.0])
	fun `vector scalar division results in a new vector by dividing its components`(scalar: Double) {
		val vector = Vector(1, 1)
		val scaled = vector / scalar
		assertThat(vector.x, `is`(1.0))
		assertThat(vector.y, `is`(1.0))

		assertThat(scaled.x, `is`(1.0 / scalar))
		assertThat(scaled.y, `is`(1.0 / scalar))
	}

	@Test
	fun `vector(2,2) divided by 2 on assigning changes the vector to vector(1,1)`() {
		val vector = Vector(2, 2)
		vector /= 2
		assertThat(vector, `is`(Vector(1, 1)))
	}

	@Test
	fun `vector(2,2) divided by Vector(2, 2) is vector(1,1)`() {
		assertThat(Vector(2, 2) / Vector(2, 2), `is`(Vector(1, 1)))
	}

	@ParameterizedTest
	@CsvSource("1336, 1336, 77, 77", "1.336, 13.36, 0.001, 0.01")
	fun `vector division results in a new vector by dividing its components`(x1: Double, y1: Double, x2: Double, y2: Double) {
		val vector = Vector(x1, y1)
		val product = vector / Vector(x2, y2)

		assertThat(vector.x, `is`(x1))
		assertThat(vector.y, `is`(y1))

		assertThat(product.x, `is`(x1 / x2))
		assertThat(product.y, `is`(y1 / y2))
	}

	@Test
	fun `vector(2,2) divided by vector(2, 2) on assigning changes the vector to vector(1,1)`() {
		val vector = Vector(2, 2)
		vector /= Vector(2, 2)
		assertThat(vector, `is`(Vector(1, 1)))
	}

	@ParameterizedTest
	@CsvSource("1336, 1336, 77, 77", "1.336, 13.36, 0.001, 0.01")
	fun `vector division on assign means division its components`(x1: Double, y1: Double, x2: Double, y2: Double) {
		val vector = Vector(x1, y1)
		vector /= Vector(x2, y2)
		assertThat(vector.x, `is`(x1 / x2))
		assertThat(vector.y, `is`(y1 / y2))
	}

	@Test
	fun `same vector cannot be added twice into a hash based set`() {
		val vector = Vector(1, 1)
		val vectors = HashSet<Vector>()
		vectors.addAll(listOf(vector, vector))

		assertThat(vectors.size, `is`(1))
		assertThat(vectors, contains(vector))
	}

	@Test
	fun `length of vector(0,0) is 0`() {
		assertThat(Vector(0, 0).length(), `is`(0.0))
	}

	@Test
	fun `length of vector(1,0) is 1`() {
		assertThat(Vector(1, 0).length(), `is`(1.0))
	}

	@Test
	fun `length of vector(-1,0) is 1`() {
		assertThat(Vector(-1, 0).length(), `is`(1.0))
	}

	@Test
	fun `length of vector(2,0) is 2`() {
		assertThat(Vector(2, 0).length(), `is`(2.0))
	}

	@Test
	fun `length of vector(0,1) is 1`() {
		assertThat(Vector(0, 1).length(), `is`(1.0))
	}

	@Test
	fun `length of vector(0,-1) is 1`() {
		assertThat(Vector(0, -1).length(), `is`(1.0))
	}

	@Test
	fun `length of vector(0,2) is 2`() {
		assertThat(Vector(0, 2).length(), `is`(2.0))
	}

	@Test
	fun `length of vector(1,1) is sqrt(2)`() {
		assertThat(Vector(1, 1).length(), `is`(sqrt(2.0)))
	}

	@ParameterizedTest
	@CsvSource("1336, 1336, 77, 77", "1.336, 13.36, 0.001, 0.01")
	fun `length of vector is the sum of its component squares`(x: Double, y: Double) {
		assertThat(Vector(x, y).length(), `is`(sqrt(x * x + y * y)))
	}

	@Test
	fun `vector(0,0) normalized vector(0,0)`() {
		assertThat(Vector(0, 0).normalized(), `is`(Vector(0, 0)))
	}

	@Test
	fun `vector(0,1) normalized vector(0,1)`() {
		assertThat(Vector(0, 1).normalized(), `is`(Vector(0, 1)))
	}

	@Test
	fun `vector(0,2) normalized vector(0,1)`() {
		assertThat(Vector(0, 2).normalized(), `is`(Vector(0, 1)))
	}

	@Test
	fun `vector(1,0) normalized vector(1,0)`() {
		assertThat(Vector(1, 0).normalized(), `is`(Vector(1, 0)))
	}

	@Test
	fun `vector(2,0) normalized vector(1,0)`() {
		assertThat(Vector(2, 0).normalized(), `is`(Vector(1, 0)))
	}

	@ParameterizedTest
	@CsvSource("1336, 1336, 77, 77", "1.336, 13.36, 0.001, 0.01")
	fun `normalized vector has length of 1`(x: Double, y: Double) {
		assertThat(Vector(x, y).normalized().length(), `is`(closeTo(1.0, 0.0000001)))
	}
}