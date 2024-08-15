import com.android.build.gradle.LibraryExtension
import com.kakaobank.tutorial.kakobank_android.configureAndroidCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getByType

class AndroidLibraryComposePlugin : Plugin<Project>  {
    override fun apply(target: Project){
        with(target){
            with(pluginManager){
                apply("com.android.library")
            }

            val extension = extensions.getByType<LibraryExtension>()
            configureAndroidCompose(extension)
        }
    }


}