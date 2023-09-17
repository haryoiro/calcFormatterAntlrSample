/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package calcparser;

import calcparser.config.FormatOption;
import calcparser.formatter.CalcFormatter;
import calcparser.optoins.CmdAttributes;
import calcparser.optoins.CmdOptions;
import static calcparser.utils.IoUtils.pathToFile;
import static java.lang.System.exit;

public class App {

    static FormatOption formatOption = new FormatOption();

    public static void main(String[] args) {

        CmdAttributes opt = CmdOptions.parseArgs(args);
        if (opt == null) {
            CmdOptions.printHelp();
            exit(0);
        }


        if (opt.isFix()) {
            System.out.println("fix");
        }
        if (opt.isCheck()) {
            System.out.println("check");
        }
        if (opt.getOptionFile() != null) {
            formatOption = formatOption.fromPath(opt.getOptionFile());
        }

        // 指定されたすべてのファイルに対してフォーマットをかける
        if (opt.getInputFiles() != null) {
            for (String file : opt.getInputFiles()) {
                System.out.println(CalcFormatter.format(pathToFile(file), formatOption));
            }
        }

    }

}
