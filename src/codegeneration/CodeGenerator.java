package codegeneration;

import ast.definitions.FuncDefinition;
import ast.definitions.VarDefinition;
import ast.types.*;

import java.io.FileWriter;
import java.io.IOException;

public class CodeGenerator {

    private FileWriter out;

    private String inputFile;

    public CodeGenerator(String inputFile, String outputFile) throws IOException {
        this.inputFile = inputFile;
        this.out = new FileWriter(outputFile);
    }

    public void pusha(int offet) {
        try{
            out.write("\n\tpusha\t" + offet);
            out.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void pushBP(){
        try{
            out.write("\n\tpusha\tbp");
            out.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void pushb(char value){
        try{
            out.write("\n\tpushb\t" + (int) value);
            out.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void pushi(int value){
        try{
            out.write("\n\tpushi\t" + value);
            out.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void pushf(double value) {
        try{
            out.write("\n\tpushf\t" + value);
            out.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void add(Type type){
        try{
            out.write("\n\tadd\t" + type.getSuffix());
            out.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void load(Type type){
        try{
            out.write("\n\tload" + type.getSuffix());
            out.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void store(Type type){
        try{
            out.write("\n\tstore" + type.getSuffix());
            out.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void castTo(Type type, Type castType) {
        try{
            if(type instanceof IntType){
                if(castType instanceof DoubleType)
                    out.write("\n\ti2f");
                else if(castType instanceof CharType)
                    out.write("\n\ti2b");

            }
            else if(type instanceof DoubleType){
                if(castType instanceof IntType)
                    out.write("\n\tf2i");
                else if(castType instanceof CharType) {
                    out.write("\n\tf2i");
                    out.write("\n\ti2b");
                }
            }
            else if(type instanceof CharType) {
                if (castType instanceof IntType)
                    out.write("\n\tb2i");
                else if (castType instanceof DoubleType){
                    out.write("\n\tb2i");
                    out.write("\n\ti2f");
                }
            }

            out.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void arithmeticConvertTo(Type type, Type arithType) {
        if(type instanceof CharType)
            castTo(type, arithType);
    }

    public void arithmetic(String operator, Type type) {
        try {
            switch (operator) {
                case "+":
                    out.write("\n\tadd" + type.getSuffix());
                    break;
                case "-":
                    out.write("\n\tsub" + type.getSuffix());
                    break;
                case "*":
                    out.write("\n\tmul" + type.getSuffix());
                    break;
                case "/":
                    out.write("\n\tdiv" + type.getSuffix());
                    break;
                default:
                    assert false;
            }

            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void logical(String operator){
        try {
            switch (operator) {
                case "&&":
                    out.write("\n\tand");
                    break;
                case "||":
                    out.write("\n\tor");
                    break;
                default:
                    assert false;
            }

            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void modulus(Type type) {
        try{
            out.write("\n\tmod" + type.getSuffix());
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void modulusConvertTo(Type type, Type intType) {
        if(type instanceof CharType)
            castTo(type, intType);
    }

    public void comparator(String operator, Type type) {
        try {
            switch (operator) {
                case ">" :
                    out.write("\n\tgt" + type.getSuffix());
                    break;
                case "<" :
                    out.write("\n\tlt" + type.getSuffix());
                    break;
                case ">=" :
                    out.write("\n\tge" + type.getSuffix());
                    break;
                case "<=" :
                    out.write("\n\tle" + type.getSuffix());
                    break;
                case "==" :
                    out.write("\n\teq" + type.getSuffix());
                    break;
                case "!=" :
                    out.write("\n\tne" + type.getSuffix());
                    break;
                default: assert false;
            }

            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void superType(Type type, Type superType) {
        if(type instanceof CharType || type instanceof DoubleType)
            castTo(type, superType);
    }

    public void read(Type type) {
        try {
            out.write("\n\tin" + type.getSuffix());
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(Type type) {
        try {
            out.write("\n\tout" + type.getSuffix());
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addComment(String s) {
        try {
            out.write(s);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addLine(int line) {
        try {
            out.write("\n\n#line\t" + line);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void callMain() {
        try {
            addComment("\n#source\t\"" + inputFile + "\"");
            addComment("\n\n\n' Invocation to the main function");
            out.write("\ncall main");
            out.write("\nhalt\n");
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void invokeMain(int line) {
        try {
            addLine(line);
            out.write("\n\n main:");
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    1.	Bytes to return (2)
    2.	Bytes of all the local variables (5)
    3.	Bytes of all the arguments (5)
     */
    public void returnFunctionBytes(FunctionType functionType, FuncDefinition funcDefinition) {
        try {
            int localVarsBytes = 0;
            int parametersBytes = 0;
            int bytesToReturn = functionType.getReturnType().numberOfBytes();

            for(VarDefinition vardef : funcDefinition.getVarDefinitions())
                localVarsBytes += vardef.getType().numberOfBytes();

            for(VarDefinition param : functionType.getParams())
                parametersBytes += param.getType().numberOfBytes();

            out.write("\n\tret\t" + bytesToReturn+", "+ localVarsBytes+", "+parametersBytes);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void unaryNot() {
        try {
            out.write("\n\tnot");
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void enter(int offset) {
        try {
            out.write("\n\tenter\t" + offset);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
