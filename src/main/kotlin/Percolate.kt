/**
 * Created by cory on 1/2/17.
 */

data class Site(var status: Boolean, var next: Pair<Int, Int>)

class Percolation(val n: Int) {
    val vRoot = Pair(-1, -1)
    val lRoot = Pair(n + 1, n + 1)

    var vCeiling = emptyList<Site>()
    val id: Array<Array<Site>> = Array(n, { i -> Array(n, { j -> Site(false, Pair(i, j)) }) })
    var openSites = 0

    init {
        addVRoot(vRoot, 0)
    }

    private fun addVRoot(vRoot: Pair<Int, Int>, row: Int) {
        id[row].forEachIndexed { idx, item -> id[row][idx].next = vRoot }
    }

    private fun connectCeiling(cell: Pair<Int, Int>) {
        vCeiling = vCeiling.plus(Site(true, id[cell.first][cell.second].next))
    }

    private fun connectImplicit(row: Int, col: Int) {
        val sourceSite = id[row][col]
        val checkSites: MutableList<Pair<Int, Int>> = mutableListOf()

        if (col - 1 >= 0) checkSites.add(Pair(row, col - 1))
        if (col + 1 < n) checkSites.add(Pair(row, col + 1))
        if (row - 1 >= 0) checkSites.add(Pair(row - 1, col))
        if (row + 1 < n) checkSites.add(Pair(row + 1, col))

        var sites: List<Site> = checkSites.map { i -> id[i.first][i.second] }
        sites = sites.plus(sourceSite)
        val rootNValue = sites.filter { i -> i.next == Pair(-1, -1) && i.status }
        if (rootNValue.isEmpty()) {
            sites.map { i -> i.next = lRoot }
        } else sites.map { i -> i.next = vRoot }
    }

    fun open(row: Int, col: Int) {
        if (id[row][col].status) return
        id[row][col].status = true
        connectImplicit(row, col)
        if (id.lastIndex == row) connectCeiling(Pair(row, col))
        openSites++
    }

    fun isOpen(row: Int, col: Int): Boolean {
        return id[row][col].status
    }

    fun numberOfOpenSites(): Int {
        return openSites
    }

    fun percolates(): Boolean {
        return vCeiling.any { it.next == Pair(-1, -1) }
    }
}
