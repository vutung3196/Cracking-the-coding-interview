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

    }

    // add two elements in each list to queue1
    // add all other elements to queue 2
    // 1, 2, 3
    // 4 , 5, 6
    // 7 , 8, 9, 10,
    // 0
    // 5, 13, -1
    // output: 2, 3; / 5, 6;/  9, 10; /  13, 5,/ 0 /  8 (additional elements)
    public static List<Integer> solution(List<List<Integer>> listOfElements) {
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

        for (var elements : listOfElements) {
            var container = kLargestElementsInAnArray(elements, 2);
            for (var topElement : container.topLargestElements) {
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
            for (var element : queue1) {
                result.add(element);
            }
        }
        return result;
    }

    private static Container kLargestElementsInAnArray(List<Integer> listOfElements, int k) {
        var result1 = new ArrayList<Integer>();
        var result2 = new ArrayList<Integer>();
        Collections.sort(listOfElements, Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            result1.add(listOfElements.get(i));
        }

        for (int i = k - 1; i < listOfElements.size(); i++) {
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
