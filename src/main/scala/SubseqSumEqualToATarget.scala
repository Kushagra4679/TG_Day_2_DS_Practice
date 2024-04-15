class SubseqSumEqualToATarget {
    def findSubsequencesWithSum(integerArray: Set[Int], target: Int): List[Set[Int]] = {
      def backtrack(start: Int, currentSum: Int, path: List[Int], answer: List[Set[Int]]): List[Set[Int]] = {
        if (currentSum == target) {
          answer :+ path.toSet
        } else if (currentSum > target || start >= integerArray.size) {
          answer
        } else {
          val take = backtrack(start + 1, currentSum + integerArray.toList(start), path :+ integerArray.toList(start), answer)
          val not_take = backtrack(start + 1, currentSum, path, answer)
          take ++ not_take
        }
      }

      backtrack(0, 0, List(), List())
    }
  }