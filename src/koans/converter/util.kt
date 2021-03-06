package koans.converter

import java.io.File

fun File.subFile(name: String) = File("$path/$name")

fun File.structureFile() = subFile(MANIFEST_JSON)

fun newDir(name: String) = File(name).apply {
    if (exists()) deleteRecursively()
    mkdir()
}

fun String.addPackageName(fileName: String, packageName: String) =
        "package $packageName" + (if (fileName.endsWith("java")) ";" else "") + "\n\n" + this

fun String.addPackageNameAndImportForTests(fileName: String, packageName: String) =
        ("import $packageName.*\n" + this).addPackageName(fileName, "$packageName.tests")

fun String.isSourceCodeFileName() = CODE_FILE_EXTENSIONS.any { this.endsWith(it) } && !contains("-wb")

enum class Mode { WEB_DEMO, EDUCATIONAL_PLUGIN }

fun String.transformUtilFile(mode: Mode) = replace("Mode.???", "Mode." + mode.name)

fun String.transformName(mode: Mode): String {
    val suffix = if (mode == Mode.WEB_DEMO) "-wb" else "-ee"
    return if (contains(suffix)) replace(suffix, "") else this
}

fun String.replaceImports(mode: Mode, taskName: String = "") =
        replace("import LOCAL.", if (mode == Mode.WEB_DEMO) "import " else "import $taskName.")
