robot-intellij-plugin
=====================

<h2>Robot IntelliJ Plugin for Java</h2>

<h4>Author: Charles Capps</h4>
<h4>Email: charles.capps@jivesoftware.com</h4>

<p>
IntelliJ Plugin to enable syntax highlighting and other features in Robot text files. Specifically designed with Java integration in mind.
See http://plugins.jetbrains.com/plugin/7430?pr=idea for the newest version or download it from within IntelliJ!
</p>

<h3>Version 1.6.2</h3>
<ul>
    <li>Multi-resolve keywords when there are multiple keywords with the same name.</li>
    <li>Fix regex for test timeout values to be correct for all possible Robot time formats.</li>
</ul>

<h3>Version 1.6.1</h3>
<ul>
    <li>Can now find usages of Robot Keywords in text, e.g. in strings that are arguments to Keywords.</li>
    <li>Can now go to definition of Keyword from a usage in text.</li>
    <li>Parse all settings correctly, e.g. the Variables setting takes a relative file as its argument.</li>
    <li>If you have the "Highlight invalid Robot keywords?" setting enabled in Editor settings, then now
        invalid settings in the ***Settings*** table will be underlined in red.</li>
</ul>

<h3>Version 1.6.0</h3>
<ul>
    <li>Keywords with "Embedded arguments" are now handled correctly for resolving references, finding usages, etc.</li>
    <li>You can now resolve a variable that is embedded in text to the its definition.</li>
    <li>Java methods annotated with @RobotKeyword are now implicitly considered used if they are used in any Robot file.</li>
    <li>There is an option under "Editor | Error Highlighting" to highlight invalid Robot keywords in red.</li>
    <li>The above option is OFF by default, in case users have Robot Keywords imported from sources this plugin can't detect.</li>
</ul>

<h3>Version 1.5.3</h3>
<ul>
    <li>Made two improvements that were filed on Github</li>
    <li>Keywords with "embedded arguments" can now be resolved at the point of use, and find usages works.</li>
    <li>Any String argument to a Keyword can resolve to a file in a resources folder, if it refers to a valid file.</li>
    <li>You can now ctrl+click the Library Java class in a Settings table</li>
    <li>You can now resolve references to variables embedded in text, e.g. in the keyword execution "Log   My text ${foo} and ${bar}",
    can now resolve ${foo} and ${bar} correctly.</li>
</ul>

<h3>Version 1.5.2</h3>
<ul>
    <li>Fixed issue filed on the github page where Java methods that use underscores, e.g. "foo_java_keyword()" should
    autocomplete in Robot as "Foo Java Keyword".
    </li>
    <li>
    Also fixed so that finding usages of Java methods correctly removes underscores before searching the
    normalized index for Robot Keywords, so now it works to find usages of java methods with underscores.
    </li>
</ul>

<h3>Version 1.5.1</h3>
<ul>
    <li>Fixed issue filed on github where you should be able to have the [Arguments] for a Keyword
    on the same line as the title of the keyword.
    </li>
    <li>
    Generally fixed all cases where you should be able to have any line of the Keyword code after the title.
    </li>
</ul>

<h3>Version 1.5.0</h3>
<ul>
    <li>Fixed autocomplete Robot Keywords so it works with substrings, not just prefixes.</li>
    <li>Fixed autocomplete Robot Variables, so it works if you already included the closing curly brace '}'</li>
    <li>Fixed a bug where searching for 2 Test Cases with the same name in different file only returned 1 of the 2 Test Cases</li>
</ul>

<h3>Version 1.4.9</h3>
<ul>
    <li>Better error handling than previous version. If the RobotKeyword class isn't on the classpath, shouldn't
    prevent autocomplete from working for keywords in Robot files.</li>
</ul>

<h3>Version 1.4.8</h3>
<ul>
    <li>Enable autocomplete for Java Robot Keywords from Java class files, even if you don't have sources attached.</li>
</ul>

<h3>Version 1.4.7</h3>
<ul>
    <li>Enable autocomplete for Java Robot Keywords in project dependencies.</li>
</ul>

<h3>Version 1.4.6</h3>
<ul>
    <li>Added an index for Test Cases, so that searching for a Robot Test Case by name is much faster.
    I found this could be slow for large projects. You may need to invalidate you cache and restart
    Intellij after getting this update.</li>
</ul>

<h3>Version 1.4.5</h3>
<ul>
    <li>Added support for Rename refactoring for Robot Files. Any Resource Setting that includes a
    Robot File will be renamed when the file is renamed.
    </li>
</ul>
    
<h3>Version 1.4.4</h3>
<ul>
    <li>Quick fix for bug with renaming Robot files.</li>
</ul>

<h3>Version 1.4.3</h3>
<ul>
    <li>Rewrite parser BNF file, so that it handles errors more gracefully with the "recoverWhile" syntax.</li>
    <li>Simplify AST as much as possible to improve performance.</li>
    <li>Fix resolving a variable reference to a variable in a FOR loop bound.</li>
</ul>

<h3>Version 1.4.2</h3>
<ul>
    <li>Fix error handling so that the rest of the file parses correctly when there's a syntax error.</li>
    <li>Tokenize array variable element access (e.g. @{foo}[0]) with a special token so that we can highlight it like a variable.</li>
</ul>


<h3>Version 1.4.1</h3>
<ul>
    <li>Fix bug with "FOR IN" loops.</li>
</ul>

<h3>Version 1.4.0</h3>
<ul>
     <li>Rename refactoring for variables -- local variables and variables defined in Variables tables.</li>
     <li>Find usages of variables.</li>
     <li>Fix how variable scope is determined; a variable won't resolve to an assignment on a subsequent line of code.</li>
</ul>

<h3>Version 1.3.2</h3>
<ul>
    <li>Bugfixes-- fixed a stack overflow if you included the current file as a Resource, or there was a loop in
        Resource file inclusions.
     </li>
     <li>Fixed issue where you couldn't go to declaration of a variable if there was no "=" sign.</li>
     <li>Fixed issue where you couldn't go to declaration of a variable if it was defined as the empty string and was defined in a variables table.</li>
     <li>Forgot to include some generated files in git.</li>
</ul>

<h3>Version 1.3.1</h3>
<ul>
    <li>Added go-to definition for Variables. Can ctrl+click a variable to go to its definition. Works wherever the
    variable was defined: local variable, Variables table, or included Resource file.</li>
    <li>Fixed a small bug with Resource file resolving, where the wrong variable would be substituted in the resource
    file path if the same variable name was included from a resource file and existed in the variables table.
    </li>
</ul>

<h3>Version 1.3.0</h3>
<ul>
    <li>Added variable autocomplete for variables in scope, including those from included Resource files</li>
    <li>Ctrl+Click included resource file from Resource setting to go directly to file.</li>
    <li>Any text before the first Robot Table is now interpreted as a Comment, since that's how Robot works.</li>
    <li>Several minor parsing improvements.</li>
</ul>

<h3>Version 1.2.3</h3>
<ul>
    <li>Fixed Keywords syntax parsing so that [return] can be called multiple times.</li>
    <li>Fixed parsing bug with assigning multiple variables to a keyword on one line.</li>
    <li>Fixed several minor parsing bugs and added unit tests so they won't regress.</li>
    <li>Fixed minor bug with autocomplete.</li>
</ul>

<h3>Version 1.2.2</h3>
<ul>
    <li>Added support for parsing FOR IN RANGE, and FOR IN loops in the Robot language.</li>
    <li>Fixed parsing of several edge cases, such as how Robot variables can have numbers for their name,
    and Settings can have spaces in-between letters and are case-insensitive.</li>
    <li>Added Unit tests to improve code quality and be sure many use cases are parsing correctly.</li>
</ul>

<h3>Version 1.2.1</h3>
<ul>
    <li>Greatly improved autocomplete performance, and performance throughout the plugin.</li>
    <li>Created PsiStub indexes for RobotKeywordDef class to speed up all lookups of Robot keyword definitions in Robot files.</li>
    <li>Also sped up lookups of Java Robot keywords by directly using the Annotation stub index that IntelliJ provides.</li>
    <li>Fix minor parsing bug, where an argument to a Keyword Definition couldn't be an array type, e.g. @{myVar}.</li>
</ul>

<h3>Version 1.2.0</h3>
<ul>
<li>Added line continuation support with the ellipsees (...) syntax used by Robot</li>
<li>Made parsing far more accurate, including the characters allowed in various contexts, etc.</li>
<li>Fixed a regression with rename refactoring not working for Robot-defined keywords with a space in the name.</li>
</ul>

<h3>Version 1.1.9</h3>
<ul>
   <li>
    Fixed minor bug with structure view always displaying the expand arrow for leaf elements.
   </li>
   <li>
   Added icons for structure view and autocomplete.
   </li>
   <li>
   Fixed autocomplete bug with Keywords not completing if you've typed more than 1 word.
   </li>
   <li>
   Improved autocomplete to display the arguments of the Java keyword / Robot keyword. (May need to see if this
   negatively affects performance for large projects since all Java keywords are in scope. May need to
   only autocomplete the Robot keywords that are in scope, since this is something we can determine easily.)
   </li>
</ul>

<h3>Version 1.1.8</h3>
<ul>
   <li>
    Fix to add back case-insensitivity of finding the Java Keyword definition from a Keyword usage that was broken
    with performance improvements in version 1.1.6 and 1.1.7 improvements.
   </li>
</ul>

<h3>Version 1.1.7</h3>
<ul>
   <li>
    Make parsing the settings table more lenient, since you can have spaces at the start of a line. 
    Produce fewer Bad syntax tokens, because this may cause performance issues when there's a large text file with
    invalid robot syntex in the project. Invalid syntax will be handled at the parser layer. 
   </li>
</ul>

<h3>Version 1.1.6</h3>
<ul>
<li>
Performance improvements - use the Java Stub Index to search for methods when we're searching by the exact name.
Use the word index when searching for Robot keyword definitions in Robot files.
Found one case where unnecessary work may have been done.
This should improve performance for large projects that have many Robot files.
Next improvement would be to implement a StubTree and StubIndex.
</li>
</ul>

<h3>Version 1.1.5</h3>

<ul>
   <li>
      Fix a regression--accidentally compiled on Linux with Java 1.7 targeting Java 1.6, which makes it not work
      on Mac with IntelliJ Ultimate edition. Jetbrains--please fix this if possible? 
   </li>
</ul>

<h3>Version 1.1.4</h3>

<ul>
    <li>Add support for Rename Refactoring! You can rename Keywords defined in Java or Robot and the change will
    propagate to all usages of the Keyword!</li>

    <li>Fix bug with Autocomplete listing duplicate entries, and improved autocomplete.</li>

    <li>Implemented Structure View to list all Test Cases and Keyword definitions in a Robot file.</li>
</ul>

<h3>Version 1.1.3</h3>

<ul>
    <li>Fix a regression where the plugin didn't work in Ultimate edition.</li>
</ul>

<h3>Version 1.1.2</h3>
<ul>
    <li>Added the ability to find Test Cases with Go To Symbol, i.e. with the hotkey Ctrl+shift+alt+n.</li>
</ul>

<h3>Version 1.1.1</h3>

<ul>
    <li>Fixed a bug with tag auto-completion from version 1.1.0.</li>
</ul>

<h3>Version 1.1.0</h3>

<ul>
    <li>Added full syntax error highlighting support! The Robot language is now fully parsed!</li>
    <li>Common Robot errors will be caught before runtime, such as assigning a variable to a String instead of a Keyword.</li>
    <li>Fixed a minor bug where Autocomplete would suggest lowercase Java methods.</li>
    <li>Fixed a minor bug where Autocomplete suggestions would not have spaces between words where appropriate.</li>
</ul>

<h3>Version 1.0.6</h3>
<ul>
    <li>Added templates so you can create a Robot Test Case File or Robot Keywords File from the New menu in the project explorer.</li>
    <li>Explicitly declaring dependencies on "lang" and "java" modules.</li>
    <li>Hoping above change will cause this plugin to be suggested when you open a Robot file and it says "Plugins supporting files with *.robot extension are found".</li>
</ul>

<h3>Version 1.0.5</h3>
<ul>
	<li>Fixed a major bug that apparently was causing many features to not work for Mac, because Robot files were never indexed. In Ubuntu, I didn't notice any
            problems. The RobotKeywordUsagesProvider has to return a new WordsScanner each time getWordsScanner() is invoked, unless
            the given scanner is thread-safe.
    </li>
    <li>Yay, no more error messages in the event log!</li>
    <li>Added the .iml file to git, so it's easier to start working on the project.</li>
</ul>

<h3>Version 1.0.4</h3>
<ul>
    <li>Fixed a bug where keywords defined within Robot would appear twice in autocomplete.</li>
</ul>

<h3>Version 1.0.3</h3>
<ul>
    <li>You can find usages of Java-defined Robot Keywords. It will find all usages in Robot files + Java</li>
    <li>(Hopefully) fixed a bug where not all tokens were parsed in a Robot file by the words scanner for indexing.</li>
    <li>Added plugin JAR to the bin folder for easy download if you don't want to setup your environment for plugin development and compile it.</li>
</ul>

<h3>Version 1.0.2</h3>
<ul>
    <li>You can find usages of Robot keywords defined in Robot files.</li>
    <li>Autocomplete works to suggest Robot keywords as you type---and it includes robot keywords from Java methods or Robot files</li>
    <li>Reworked how searching is done in RobotKeywordDefinitionFinder. Searches by the method name against the word index when possible.
      When not possible, searches by the term "RobotKeyword" in java files, since we're are only dealing with robot keywords defined in Java
      with the @RobotKeyword annotation.
    </li>
    <li>Autocomplete robot tags as well.</li>
</ul>

<h3>Version 1.0.1</h3>
<ul>
    <li>Added ability to go to definition of a Robot keyword that's defined in Java or a robot file.</li>
    <li>Fixed some bugs in tokenizing. Robot keyword definitions are now parsed separately from robot keywords.</li>
    <li>Refactored to use a BNF file and generate the parser automatically. Trivial language at the moment, don't require much of a tree.</li>
    <li>Improved performance by only searching for java keywords in the current module. </li>
</ul>







