package CompaniesInterview.snowflake.selecttopnumber;

import java.util.*;

public class Solution {

//    Kiểu b có 5 cái list mỗi element là kiểu số có giá trị
//    ,
//    Từ 5 list đấy mỗi list lấy ra 2 thg lớn nhất
//            Enter
//    Tức phải lấy đủ 10 thg
//    Lộc
//    Nma có thể có list k có element hoặc 1 element
//    Thì phải lấy bù từ những thg list khác mà chưa từng lấu
//    à mỗi list lấy 2 thg lớn nhất sao cho lấy đủ 10 thg thì thôi. Nma có list k đủ 2 thg Thì lấy bù từ list khác
//    có list có 1 chẳng hạn Nma là lớn nhất trg đống đó
//    Ideas: Using 2 priority queues
//Thì tạo 2 priority quêu
//    Một cái lấy 2 thg lớn nhất mỗi list
//1 cái add hết đồng còn lại
//    Thế là nó duyệt r
//    K cần optimize
    public static void main(String[] args) {
        ArrayList<Integer> a1 = new ArrayList<Integer>() {
            {
                add(1);
                add(2);
                add(3);
            }
        };

        ArrayList<Integer> a2 = new ArrayList<Integer>() {
            {
                add(4);
                add(5);
                add(6);
            }
        };

        ArrayList<Integer> a3 = new ArrayList<Integer>() {
            {
                add(7);
                add(8);
                add(9);
                add(10);
            }
        };

        ArrayList<Integer> a4 = new ArrayList<Integer>() {
            {
                add(0);
            }
        };

        ArrayList<Integer> a5 = new ArrayList<Integer>() {
            {
                add(5);
                add(13);
                add(-1);
            }
        };

        var input = new ArrayList<ArrayList<Integer>>() {
            {
                add(a1);
                add(a2);
                add(a3);
                add(a4);
                add(a5);
            }
        };

        var output = solution(input);
        for (var element : output) {
            System.out.println(element);
        }
    }

    // add two elements in each list to queue1
    // add all other elements to queue 2
    // 1, 2, 3
    // 4 , 5, 6
    // 7 , 8, 9, 10,
    // 0
    // 5, 13, -1
    // output: 2, 3; / 5, 6;/  9, 10; /  13, 5,/ 0 /  8 (additional elements)
    // Time complexity: O(nlogn)
    public static List<Integer> solution(ArrayList<ArrayList<Integer>> listOfElements) {
        if (listOfElements == null || listOfElements.size() == 0) return new ArrayList<>();
        var result = new ArrayList<Integer>();
        var queue1 = new PriorityQueue<Integer>(Collections.reverseOrder());
        var queue2 =  new PriorityQueue<Integer>(Collections.reverseOrder());

        // idea:
        // queue1:
        // 2, 3
        // 5, 6,
        // 9, 10,
        // 0
        // 13, 5

        // queue2:
        // 1, 4, 7, 8, -1 => select 8
        // => result: 2, 3, 5, 6, 9, 10, 0, 13, 5
        // 5 elements
        for (var elements : listOfElements) {
            // o(nlogn)
            var container = kLargestElementsInAnArray(elements, 2);
            for (var topElement : container.topLargestElements) {
                // O(Log(n))
                queue1.offer(topElement);
            }

            for (var otherElement : container.otherElements) {
               queue2.offer(otherElement);
            }
        }

        if (queue1.size() < 10) {
            var diff = 10 - queue1.size();
            for (int i = 0; i < diff; i++) {
                var element = queue2.poll();
                queue1.offer(element);
            }
        }

        if (queue1.size() == 10) {
            result.addAll(queue1);
        }
        return result;
    }

    private static Container kLargestElementsInAnArray(List<Integer> listOfElements, int k) {
        // check exception
        var result1 = new ArrayList<Integer>();
        var result2 = new ArrayList<Integer>();
        // O((n*logn) + k)
        listOfElements.sort(Collections.reverseOrder());
        if (listOfElements.size() < k) {
            result1.addAll(listOfElements);
            return new Container(result1, result2);
        }

        for (int i = 0; i < k; i++) {
            result1.add(listOfElements.get(i));
        }

        for (int i = k; i < listOfElements.size(); i++) {
            result2.add(listOfElements.get(i));
        }

        return new Container(result1, result2);
    }

    public static class Container {
        public List<Integer> topLargestElements;
        public List<Integer> otherElements;

        public Container(List<Integer> topLargestElements, List<Integer> otherElements) {
            this.topLargestElements = topLargestElements;
            this.otherElements = otherElements;
        }
    }
}
