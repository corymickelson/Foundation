import java.util.*

/**
 * Created by cory on 1/6/17.
 */

class Dequeue {
    var q = Array(100, { i -> 0 })
    var head = 50
    var tail = 51
    private var length = 0

    fun prepend(item: Int) {
        if (head == q.size / 4) sizeUp()
        q[head] = item
        head--
        length++
    }

    fun append(item: Int) {
        if (tail == (q.size / 4) * 3) sizeUp()
        q[tail] = item
        tail--
        length++
    }

    fun first(): Int {
        val v = q[head]
        q[head] = 0
        head++
        length--
        return v
    }

    fun last(): Int {
        val v = q[tail]
        q[tail] = 0
        tail--
        length--
        return v
    }

    private fun sizeUp() {
        val _q = Array((q.size * 2), { i -> 0 })
        val _center = _q.size / 2
        val subArray = q.copyOfRange(head, tail).toList()
        var left = subArray.subList(0, subArray.size / 2)
        var right = subArray.subList(subArray.size / 2, subArray.lastIndex)
        var rightCounter = 1
        var leftCounter = 0

        while (!left.isEmpty()) {
            _q[_center - leftCounter] = left.last()
            left = left.subList(0, left.lastIndex)
            leftCounter++
        }
        while (!right.isEmpty()) {
            _q[_center + rightCounter] = right.first()
            right = right.subList(0, right.lastIndex)
            rightCounter++
        }
        q = _q
        head = _center - leftCounter + 1
        tail = _center + rightCounter - 1
    }

    private fun sizeDown() {
        val _q = Array((q.size / 2), { i -> 0 })
        val _center = _q.size / 2
        val sub = q.copyOfRange(head, tail).toList()
        var left = sub.subList(0, sub.size / 2)
        var right = sub.subList(sub.size / 2, sub.lastIndex)
        var rightCounter = 1
        var leftCounter = 0

        while (!left.isEmpty()) {
            _q[_center - leftCounter] = left.last()
            left = left.subList(0, left.lastIndex)
            leftCounter++
        }
        while (!right.isEmpty()) {
            _q[_center + rightCounter] = right.first()
            right = right.subList(0, right.lastIndex)
            rightCounter++
        }
        q = _q
        head = _center - leftCounter + 1
        tail = _center + rightCounter - 1
    }

}
