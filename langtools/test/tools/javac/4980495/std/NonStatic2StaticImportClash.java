/*
 * @test  /nodynamiccopyright/
 * @bug 7101822
 * @summary Check the when clashing types are imported through an ordinary and static import,
 *          the compile-time error is properly reported.
 * @compile/fail/ref=NonStatic2StaticImportClash.out -XDrawDiagnostics NonStatic2StaticImportClash.java p1/A1.java p2/A2.java
 *
 */

import p1.A1.f;
import static p2.A2.f;

public class NonStatic2StaticImportClash {
}
