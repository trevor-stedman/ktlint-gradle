package org.jlleitschuh.gradle.ktlint

import org.gradle.api.model.ObjectFactory
import org.gradle.api.provider.Property
import org.jlleitschuh.gradle.ktlint.reporter.ReporterType

/**
 * Extension class for configuring the [KtlintPlugin].
 */
open class KtlintExtension(
    objectFactory: ObjectFactory
) {
    /**
     * The version of ktlint to use.
     */
    val version: Property<String> = objectFactory.property()

    /**
     * Enable verbose mode.
     */
    var verbose = false
    /**
     * Enable debug mode.
     */
    var debug = false
    /**
     * Enable android mode.
     */
    var android = false
    /**
     * Enable console output mode.
     */
    var outputToConsole = true
    /**
     * Whether or not to allow the build to continue if there are warnings;
     * defaults to {@code false}, as for any other static code analysis tool.
     * <p>
     * Example: `ignoreFailures = true`
     */
    var ignoreFailures = false
    /**
     * The ruleset(s) of ktlint to use.
     */
    var ruleSets: Array<String> = arrayOf()

    /**
     * Report output formats.
     *
     * Available values: plain, plain_group_by_file, checkstyle, json.
     *
     * **Note** for Gradle scripts: for now all values should be uppercase due to bug in Gradle.
     *
     * Default is plain.
     */
    var reporters: Array<ReporterType> = arrayOf(ReporterType.PLAIN)

    init {
        version.set("0.27.0")
    }
}
