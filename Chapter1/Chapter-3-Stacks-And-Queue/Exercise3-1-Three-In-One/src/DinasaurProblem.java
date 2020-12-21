// The first file contains statistics about various dinosaurs. The second file contains additional data.
// Given the following formula, speed = ((STRIDE_LENGTH / LEG_LENGTH) - 1) * SQRT(LEG_LENGTH * g)
// Where g = 9.8 m/s^2 (gravitational constant)
// Write a program to read in the data files from disk, 
// it must then print the names of only the bipedal dinosaurs from fastest to slowest.
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DinasaurProblem {
    public static void main(String[] args) throws IOException {
        List<Dinosaurs> dinosaursList = new ArrayList<Dinosaurs>();
        Path pathToFile = Paths.get("/home/tungvu/vutung/Cracking-the-coding-interview/Cracking-the-coding-interview/Chapter1/Chapter-3-Stacks-And-Queue/Exercise3-1-Three-In-One/src/dataset2.csv");
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)){
            br.readLine();
            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(",");
                Dinosaurs dinosaurs = createDinosaursFromSecondCsv(attributes);
                if (dinosaurs.stance.equals("bipedal")) {
                    dinosaursList.add(dinosaurs);
                }
                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        pathToFile = Paths.get("/home/tungvu/vutung" +
                        "/Cracking-the-coding-interview/Cracking-the-coding-interview/" +
                        "Chapter1/Chapter-3-Stacks-And-Queue/Exercise3-1-Three-In-One/src/dataset1.csv");
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)){
            br.readLine();
            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(",");
                Dinosaurs dinosaurs = createDinosaursFromFirstCsv(attributes);
                var firstELement = dinosaursList.stream()
                        .filter(o -> o.name.equals(dinosaurs.name)).findFirst();
                if (firstELement.isPresent()) {
                    firstELement.get().legLength = dinosaurs.legLength;
                } else {
//                    dinosaursList.removeIf(o -> !o.name.equals(dinosaurs.name));
                }
                line = br.readLine();

            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        for (Dinosaurs dino: dinosaursList) {
            dino.setSpeed();
        }
        Comparator<Dinosaurs> comparator = Comparator.comparing(person -> person.speed);

        var a = dinosaursList.stream().sorted(comparator).collect(Collectors.toList());;

        for (Dinosaurs ax: a) {
            System.out.println(ax.name + " " + ax.speed);
        }
    }

    private static Dinosaurs createDinosaursFromSecondCsv(String[] attributes) {
        Dinosaurs dinosaurs = new Dinosaurs();
        dinosaurs.name = attributes[0];
        dinosaurs.strideLength = Double.parseDouble(attributes[1]);
        dinosaurs.stance = attributes[2];
        return dinosaurs;
    }

    private static Dinosaurs createDinosaursFromFirstCsv(String[] attributes) {
        Dinosaurs dinosaurs = new Dinosaurs();
        dinosaurs.name = attributes[0];
        dinosaurs.legLength = Double.parseDouble(attributes[1]);
        dinosaurs.diet = attributes[2];
        return dinosaurs;
    }
}

class Dinosaurs {
    public String name;
    public double legLength;
    public String diet;
    public String stance;
    public double strideLength;
    public double speed;
    public void setSpeed() {
        speed = ((strideLength / legLength) - 1) * Math.sqrt(legLength * 9.8);
    }
}