package bag;

import java.util.List;

public class Bag {
	
	
//	
//	
//    private static void calculateCosineSimilarities(StringFeatureVector sourceQuestion, List<StringFeatureVector> destinationQuestions) {
//		for (int i = 0; i < destinationQuestions.size(); i++) {
//		System.out.println("Between src and dest " + i + ", cosine similarity = " + calculateCosineSimilarity(sourceQuestion, destinationQuestions.get(i)));
//		}
//	}
//    private static double calculateCosineSimilarity(StringFeatureVector vector1, StringFeatureVector vector2)
//    {
//        double dotProduct = calculateDotProduct(vector1, vector2);
//        double magnitudeOfVector1 = calculateMagnitudeOfVector(vector1);
//        double magnitudeOfVector2 = calculateMagnitudeOfVector(vector2);
//
//        return dotProduct / (magnitudeOfVector1 * magnitudeOfVector2);
//    }
//    
//    private static double calculateDotProduct(StringFeatureVector vector1, StringFeatureVector vector2)
//    {
//
//        double dotProduct = 0;
//        for (int i = 0 ; i < vector1.size(); i++)
//        {
//            int index_v1 = vector1.getIndex(i);
//            int j = 0;
//            while (j < vector2.size())
//            {
//                if (vector2.getIndex(j) == index_v1)
//                {
//                    dotProduct += (vector1.getWeight(i) * vector2.getWeight(j));
//                    break;
//                }
//                j++;
//            }
//        }
//
//        return dotProduct;
//    }
//
//    private static double calculateMagnitudeOfVector(StringFeatureVector vector)
//    {
//        double dotProduct = 0;
//
//        for (int i = 0; i < vector.size(); i++)
//        {
//            dotProduct += Math.pow(vector.getWeight(i), 2);
//        }
//
//        return Math.sqrt(dotProduct);
//    }
//}

