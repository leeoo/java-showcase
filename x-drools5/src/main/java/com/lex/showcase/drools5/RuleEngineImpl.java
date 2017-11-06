package com.lex.showcase.drools5;

import org.drools.RuleBase;
import org.drools.StatefulSession;
import org.drools.compiler.DroolsParserException;
import org.drools.compiler.PackageBuilder;
import org.drools.spi.Activation;
import org.drools.spi.AgendaFilter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class RuleEngineImpl implements RuleEngine {
    private RuleBase ruleBase;


    @Override
    public void init() {
        System.setProperty("drools.dateformat", "yyyy-MM-dd HH:mm:ss");
        ruleBase = SingleRuleFactory.getRuleBase();
        try {
            PackageBuilder packageBuilder = getPackageBuilderFile();
            ruleBase.addPackages(packageBuilder.getPackages());
        } catch (DroolsParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void refresh() {
        ruleBase = SingleRuleFactory.getRuleBase();
        org.drools.rule.Package[] packages = ruleBase.getPackages();
        for (org.drools.rule.Package items : packages) {
            ruleBase.removePackage(items.getName());
        }
        init();
    }

    @Override
    public void execute(EntityRule entityRule) {
        if (ruleBase.getPackages() == null || ruleBase.getPackages().length == 0) {
            return;
        }
        StatefulSession statefulSession = ruleBase.newStatefulSession();
        statefulSession.insert(entityRule);
        statefulSession.fireAllRules(new AgendaFilter() {
            @Override
            public boolean accept(Activation activation) {
                return !activation.getRule().getName().contains("_test");
            }
        });
        statefulSession.dispose();
    }

    private PackageBuilder getPackageBuilderFile() throws Exception {
        List<String> drlFilePath = getRuleFile();
        List<Reader> readers = loadRuleFile(drlFilePath);
        PackageBuilder packageBuilder = new PackageBuilder();
        for (Reader r : readers) {
            packageBuilder.addPackageFromDrl(r);
        }
        if (packageBuilder.hasErrors()) {
            throw new Exception(packageBuilder.getErrors().toString());
        }
        return packageBuilder;
    }

    private List<Reader> loadRuleFile(List<String> drlFilePath) throws FileNotFoundException {
        if (drlFilePath == null || drlFilePath.size() == 0) {
            return null;
        }
        List<Reader> readers = new ArrayList<>();
        for (String ruleFilePath : drlFilePath) {
            readers.add(new FileReader(new File(ruleFilePath)));
        }
        return readers;
    }

    private List<String> getRuleFile() {
        List<String> drlFilePath = new ArrayList<>();
        String path = "/Users/libo/workshop/java-showcase/x-drools5/src/main/java/com/lex/showcase/drools5/drools_rule.drl";
        drlFilePath.add(path);
        return drlFilePath;
    }
}
