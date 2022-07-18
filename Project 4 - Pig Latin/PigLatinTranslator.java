import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.Arrays;

public class PigLatinTranslator
{
    public static void main(String[] args) throws IOException
    {
        File inputFile = new File(args[0]);
        File outputFile = new File(args[1]);

        if(args.length != 2)
        {
            System.out.println("Usage: java PigLatinTranslator inputFile outputFile");
            System.out.println("You need two command-line parameters for this program");
            return;
        }

        FileReader reader = null;

        try 
        {
            reader = new FileReader(inputFile);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("This file doesn't exist!");
            System.out.println("Please Try Again!");
        }

        FileWriter writer = new FileWriter(outputFile);
        
        int IntTranslate;
        int placement = 0;
        char TranslateReader;

        char [] ReaderCursor = new char[0];

        while (( IntTranslate = reader.read() ) !=-1 )
        {
            TranslateReader = (char)IntTranslate;

            if(TranslateReader == '<')
            {
                if(ReaderCursor.length > 0)
                {
                    writer.write(Translator(ReaderCursor));
                    placement = 0;
                    ReaderCursor = new char[0];
                }

                writer.write(TranslateReader);

                IntTranslate = reader.read();
                TranslateReader = (char)IntTranslate;

                while(TranslateReader != '>')
                {
                    writer.write(TranslateReader);
                    IntTranslate = reader.read();
                    TranslateReader = (char)IntTranslate;
                }

                writer.write(TranslateReader);
            }

            else if(isPunctuation(TranslateReader))
            {
                if(ReaderCursor.length > 0)
                {
                    writer.write(Translator(ReaderCursor));
                    writer.write(TranslateReader);

                    placement = 0;
                    ReaderCursor = new char[0];
                }
            }

            else if(TranslateReader == '&')
            {
                if(ReaderCursor.length > 0)
                {
                    writer.write(Translator(ReaderCursor));
                    placement = 0;
                    ReaderCursor = new char[0];
                }

                writer.write(TranslateReader);

                IntTranslate = reader.read();
                TranslateReader = (char)IntTranslate;

                while(TranslateReader != ':')
                {
                    writer.write(TranslateReader);
                    IntTranslate = reader.read();
                    TranslateReader = (char)IntTranslate;
                }

                writer.write(TranslateReader); 
            }

            else
            {
                if(!Character.isWhitespace(TranslateReader))
                {
                    if(placement == ReaderCursor.length)
                    {
                        ReaderCursor = Arrays.copyOf(ReaderCursor, ReaderCursor.length + 1);
                    }

                    ReaderCursor[placement] = TranslateReader;
                    placement++;
                }
                else if(Character.isWhitespace(TranslateReader))
                {
                    if(ReaderCursor.length > 0)
                    {
                        writer.write(Translator(ReaderCursor));
                        writer.write(TranslateReader);
                        placement = 0;
                        ReaderCursor = new char[0];
                    }
                }
            }
        
        }
        
        reader.close();
        writer.flush();
        writer.close();

        System.out.println("Successful! " + args[0] + "has been translated using PigLatin and saved as " + args[1]);
    }

    private static char[] Translator(char[] PigTarget)
    {
        boolean hasDigits = false;
        boolean hasVowel = false;
        boolean startsWithVowel = false;
        char[] converted = new char[PigTarget.length];

        for(int i = 0; i < PigTarget.length; i++)
        {
            if(isVowel(PigTarget[i], i))
            {
                hasVowel = true;
            }

            if(Character.isDigit(PigTarget[i]))
            {
                hasDigits = true;
            }
        }

        startsWithVowel = isVowel(PigTarget[0],0);

        if(hasVowel == true && hasDigits == false)
        {
            if(startsWithVowel == true)
            {
                int temp2 = PigTarget.length;
                converted = Arrays.copyOf(PigTarget, temp2+3);
                converted[temp2]='w';
                converted[temp2+1]='a';
                converted[temp2+2] = 'y';
            }

            else if(startsWithVowel == false)
            {
                int Index = 0;
                int NumberCounter = 0;
                int temp2 = PigTarget.length;
                char[] consonants = new char[0];
                boolean upperCase = false;
                boolean VowelTracker = false;

                for(int i = 0; i < PigTarget.length && VowelTracker == false; i ++)
                {
                    if(isVowel(PigTarget[i], i))
                    {
                        Index = i;
                        VowelTracker = true;
                    }

                    if(VowelTracker == false)
                    {
                        if(NumberCounter == consonants.length)
                        {
                            consonants = Arrays.copyOf(consonants, consonants.length+1);
                        }

                        consonants[NumberCounter] = PigTarget[i];
                        upperCase = (Character.isUpperCase(consonants[0]));
                        NumberCounter++;
                    }
                }

                if(upperCase)
                {
                    consonants[0] = Character.toLowerCase(consonants[0]);
                }

                for(int i = Index; i < (PigTarget.length); i++)
                {
                    if(upperCase && i == Index)
                    {
                        PigTarget[i] = Character.toUpperCase(PigTarget[i]);
                    }
                    
                    converted[i-NumberCounter] = PigTarget[i];
                }

                converted = Arrays.copyOf(converted, PigTarget.length + 2);
                int temp3 = 0;

                for(int i = temp2 - NumberCounter; temp3 < NumberCounter; i++)
                {
                    converted[i] = consonants[temp3];
                    temp3++;
                }

                if(converted.length > 0)
                {
                    converted[converted.length-2] = 'a';
                    converted[converted.length-1] = 'y';
                }
            }
        }

        else
        {
            converted = Arrays.copyOf(PigTarget, PigTarget.length);
        }

        return converted;
    }


    private static boolean isPunctuation(char TranslateReader)
    {
        boolean temp = false;

        if(TranslateReader == ',' || TranslateReader == '.' || TranslateReader == '!' || TranslateReader == '?' || TranslateReader == ':' || TranslateReader == '`' || TranslateReader == '%' || TranslateReader == '*' || TranslateReader == '(' || TranslateReader == ')' || TranslateReader == '[' || TranslateReader == ']' || TranslateReader == '{' || TranslateReader == '}' || TranslateReader == '#')
        {
            temp = true;
        }

        return temp;
    }

    private static boolean isVowel(char l, int q)
    {
        boolean vowel = false;

        l = Character.toLowerCase(l);
        if(l == 'a' || l == 'e' || l == 'i' || l == 'o' || l == 'u' || l == 'y')
        {
            vowel = true;
        }

        if(q == 0 && l == 'y')
        {
            vowel = false;
        }

        return vowel;
    }

}
