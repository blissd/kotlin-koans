package i_introduction._4_Lambdas

//public class JavaCode4 extends JavaCode {
//    public boolean task4(Collection<Integer> collection) {
//        return Iterables.any(collection, new Predicate<Integer>() {
//            @Override
//            public boolean apply(Integer element) {
//                return element % 42 == 0;
//            }
//        });
//    }
//}

object KotlinCode4 {
    fun task4(collection: Collection<Int>): Boolean {
        return collection.any{ it % 42 == 0 }
    }
}