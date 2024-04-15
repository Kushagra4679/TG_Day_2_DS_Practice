class SubseqSumEqualToATarget {
    def findSubsequencesWithSum(integerArray: Set[Int], target: Int): List[Set[Int]] = {
      def subseqFinder(start: Int, currentSum: Int, path: List[Int], answer: List[Set[Int]]): List[Set[Int]] = {
        if (currentSum == target) {
          answer :+ path.toSet
        } else if (currentSum > target || start >= integerArray.size) {
          answer
        } else {
          val take = subseqFinder(start + 1, currentSum + integerArray.toList(start), path :+ integerArray.toList(start), answer)
          val not_take = subseqFinder(start + 1, currentSum, path, answer)
          take ++ not_take
        }
      }

      subseqFinder(0, 0, List(), List())
    }
  }