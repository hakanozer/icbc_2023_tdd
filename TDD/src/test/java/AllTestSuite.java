import org.junit.jupiter.api.DisplayName;
import org.junit.platform.suite.api.*;

@Suite
//@SelectClasses({DBTest.class, FileTest.class, GlabalInfoTest.class})
@SelectPackages({""})
@IncludeTags(Config.secuirty)
//@ExcludeTags("rest")
//@IncludeClassNamePatterns("^.*File.*")
@DisplayName("All Rest Test Suite")
public class AllTestSuite {
}
