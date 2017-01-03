
/**
 * Created by cory on 1/1/17.
 */
class Union(size: Int) {
    var id: Array<Int> = Array(size, { i -> i })
    var lb: Array<Int> = Array(size, { i -> 1})

    fun connect(p: Int, q: Int) {
        id[p] = id[q]
    }

    tailrec fun find(p:Int): Int =
            if(id[p] == p) p else find(id[p])

    fun union(p: Int, q: Int) {
        var qRoot = find(q)
        var pRoot = find(p)

        if(qRoot == pRoot) return

        if(lb[q] > lb[p]) {
            pRoot = qRoot
            lb[q] += lb[p]
        }
        else {
            qRoot = pRoot
            lb[p] == lb[q]
        }
    }

    fun count(): Int = id.size

}
