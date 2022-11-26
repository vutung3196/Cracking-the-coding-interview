package CompaniesInterview.karat.courseoverlap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

        String[][] coursePairs = {
                {"58", "Software Design"},
                {"58", "Linear Algebra"},
                {"94", "Art History"},
                {"94", "Operating Systems"},
                {"17", "Software Design"},
                {"58", "Mechanics"},
                {"58", "Economics"},
                {"17", "Linear Algebra"},
                {"17", "Political Science"},
                {"94", "Economics"},
                {"25", "Economics"}
        };

        var output = find(coursePairs);
        for (var a : output) {
            System.out.println(a.studentIds);
            System.out.println(a.overlappedCourses);
        }
    }

//    Sample Input:
//    student_course_pairs_1 = [
//            ["58", "Software Design"],
//            ["58", "Linear Algebra"],
//            ["94", "Art History"],
//            ["94", "Operating Systems"],
//            ["17", "Software Design"],
//            ["58", "Mechanics"],
//            ["58", "Economics"],
//            ["17", "Linear Algebra"],
//            ["17", "Political Science"],
//            ["94", "Economics"],
//            ["25", "Economics"],
//            ]
//
//    Sample Output (pseudocode, in any order):
//
//    find_pairs(student_course_pairs_1) =>
//    {
//  [58, 17]: ["Software Design", "Linear Algebra"]
//  [58, 94]: ["Economics"]
//  [58, 25]: ["Economics"]
//  [94, 25]: ["Economics"]
//  [17, 94]: []
//  [17, 25]: []
//    }
    public static List<CourseOverlapPair> find(String[][] coursePairs) {
        if (coursePairs == null || coursePairs.length == 0 || coursePairs[0].length == 0) return new ArrayList<>();
        var studentToCourses = new HashMap<String, HashSet<String>>();
        var result = new ArrayList<CourseOverlapPair>();
        for (var pair : coursePairs) {
            var studentId = pair[0];
            var course = pair[1];
            if (studentToCourses.containsKey(studentId)) {
                var currenCourse = studentToCourses.get(studentId);
                currenCourse.add(course);
                studentToCourses.put(studentId, currenCourse);
            } else {
                var newCourses = new HashSet<String>();
                newCourses.add(course);
                studentToCourses.put(studentId, newCourses);
            }
        }

        // loop through all each student.
        var studentIds = studentToCourses.keySet().toArray();
        for (int i = 0; i < studentIds.length; i++) {
            for (int j = 1; j < studentIds.length; j++) {
                if (i == j) continue;
                for (var overlappedObject : result) {
                     if (overlappedObject.studentIds.contains(studentIds[i]) && overlappedObject.studentIds.contains(studentIds[j])) {
                         continue;
                     }
                 }
                var overlappedCourses = new ArrayList<String>();
                var pair = new CourseOverlapPair();
                pair.studentIds = new ArrayList<>();
                pair.studentIds.add(studentIds[i].toString());
                pair.studentIds.add(studentIds[j].toString());
                for (var course1 : studentToCourses.get(studentIds[i].toString())) {
                    for (var course2 : studentToCourses.get(studentIds[j].toString())) {
                        if (course1.equals(course2)) {
                            overlappedCourses.add(course1);
                        }
                    }
                }
                pair.overlappedCourses = overlappedCourses;
                result.add(pair);
            }
        }

        return result;

    }


    /**
     * Students may decide to take different "tracks" or sequences of courses in the Computer Science curriculum.
     * There may be more than one track that includes the same course,
     * but each student follows a single linear track from a "root" node to a "leaf" node.
     * In the graph below, their path always moves left to right.
     *
     * Write a function that takes a list of (source, destination) pairs, and
     * returns the name of all of the courses that the students could be taking when they are halfway through their track of courses.
     * Create a graph and form all the half way paths.
     */



    private static class CourseOverlapPair {
        public List<String> studentIds;
        public List<String> overlappedCourses;
}
}
