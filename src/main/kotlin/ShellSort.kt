/**
 * Created by cory on 1/14/17.
 */

class ShellSort<T>(var subject: Array<T>) where T : Comparable<T> {
    private var gap = subject.size / 2
    private var interval = 1
    private var indices = emptyList<Int>()

    tailrec fun shellsort() {
        indices = intervalIndexes()
        indices.forEachIndexed { idx, i -> intervalSort(idx) }
        interval++
        if (interval > gap)  {
            gap--
            interval = 1
            //if(gap == 1) InsertSort(subject)
            if (gap == 0) return
        }
        shellsort()
    }

    private fun InsertSort(subject: Array<T>) {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    tailrec private fun intervalSort(idx: Int) {
        if (idx - 1 < 0) return
        val s = subject[indices[idx]]
        val l = subject[indices[idx - 1]]
        if(s == l) return
        if (s < l) swap(indices[idx - 1], indices[idx])

        intervalSort(idx - 1)
    }

    private fun swap(s: Int, l: Int) {
        val tmp = subject[s]
        subject[s] = subject[l]
        subject[l] = tmp
    }

    private fun intervalIndexes(): List<Int> {
        var i = 0
        val indices: MutableList<Int> = mutableListOf()
        while (i < subject.size) {
            if (i % gap == interval - 1) indices.add(i)
            i++
        }
        return indices
    }
}

