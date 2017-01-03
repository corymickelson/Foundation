/**
 * Created by cory on 1/2/17.
 */

/*
@todo Need to pass in (level, value) for all operations.
 */
//[[1, 2 , 3 , 4],
// [5, 6 , 8 , 4],    connect 7, 8, 4 =
// [9, 10, 11, 12]]     id[7] = id[8] and id[8] = id[4] and if id[4] == id[4] id[4] = virtualRoot

data class Grid(var id: Array<Array<Int>>) {
    override fun equals(other: Any?): Boolean {
        return false
    }

    override fun hashCode(): Int {
        return 0
    }
}


class Percolate(n: Int, m: Int) {
    val Dimensions: Pair<Int, Int> = Pair(n, m)
    var id: Array<Array<Int>> =
            Array(n, { i -> Array(m, { j -> (i * 5) + j + 1 }) })
    var vCeiling = 0
    var vFloor = n * m + 1

    fun connect(a: Int, b: Int) {
        /*
        [[1, 2 , 3 , 4],
         [5, 6 , 7 , 8],
         [9, 10, 11, 12]]
        Connect a=7,b=3
        Find level of a,b
        Get ids of a,b (in this case they are the default initialization values)
        Set id of a to id of b
        If either is top or bottom level set also to virtual root
        Results in:

            VirtualRoot
                 \
           /  /  \   \
        [[1, 2 , 0 , 4],
         [5, 6 , 3 , 8],
         [9, 10, 11, 12]]

         If we then connected 3, 8
        [[1, 2 , 0 , 4],
         [5, 6 , 3 , 8], =
         [9, 10, 11, 12]]
         */
        val B = id[b / Dimensions.first][b]
        val A = id[a / Dimensions.first][a]
        if (A == B) return
        else {
            if (a / Dimensions.first == 0)
                id[a / Dimensions.first][a] = vCeiling
            else if (a / Dimensions.first == Dimensions.second - 1)
                id[a / Dimensions.first][a] = vFloor
            else id[a / Dimensions.first][a] = B
        }
    }

    tailrec fun root(a: Int): Int {
        val Level = a / Dimensions.first
        return if (id[Level][a] == a) a else root(id[Level][a])
    }

    fun union(a: Int, b: Int) {
        var rootOfA = root(a)
        var rootOfB = root(b)
    }
}