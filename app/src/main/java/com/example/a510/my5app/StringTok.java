package com.example.a510.my5app;


/*-------------------------------------------------------------------

StringTok.java: String with Token Operation

Copyright ⓒ 2016-Forever ACE Lab, Korea.

All Rights Reserved. Personal and non-commercial purpose only.

-------------------------------------------------------------------*/

public class StringTok extends Object {

    private static final String m_sDelimit = " +-*/<>=()&|!,;:@#$%^\t\r\n";

    private static final String m_sWhite = " \t\r\n";

    private String m_str;

    private int m_nPosTok;


    public StringTok() {

        initPosTok();

    }


    public StringTok(String str) {

        setString(str);

    }

    public StringTok(StringTok str) {

        setString(str);

    }

    public StringTok(char ch) {

        setString(ch);

    }

    public char getAt(int nPos) {

        return m_str.charAt(nPos);

    }

    public char getLastAt() {

        return getAt(getLength() - 1);

    }    // Get the last character.

    public int getLength() {

        return m_str.length();

    }

    public StringTok getToken() {

        int nInput = getLength();

        while (isWhite(m_str.charAt(m_nPosTok))) {

            m_nPosTok++;

            if (m_nPosTok >= nInput) return new StringTok();

        }

        String str = String.valueOf(m_str.charAt(m_nPosTok));

        m_nPosTok++;

        if (isDelimit(str.charAt(0))) return new StringTok(str);

        while (m_nPosTok < nInput) {

            if (isDelimit(m_str.charAt(m_nPosTok))) return new StringTok(str);

            str += m_str.charAt(m_nPosTok);

            m_nPosTok++;

        }
        return new StringTok(str);
    }

    public StringTok getTokenWhite() {

        int nInput = getLength();

        while (isWhite(m_str.charAt(m_nPosTok))) {

            m_nPosTok++;

            if (m_nPosTok >= nInput) return new StringTok();

        }

        String str = String.valueOf(m_str.charAt(m_nPosTok));

        m_nPosTok++;

        while (m_nPosTok < nInput) {

            if (isWhite(m_str.charAt(m_nPosTok))) return new StringTok(str);

            str += m_str.charAt(m_nPosTok);

            m_nPosTok++;

        }
        return new StringTok(str);
    }

    public StringTok getTokenNum() {

        StringTok sToken = getToken();

        StringTok sTokenAdd;

        if ((sToken.charAt(0) == '-' || sToken.charAt(0) == '+') && (m_nPosTok < getLength()) && !isDelimit(charAt(m_nPosTok))) {

            sTokenAdd = getToken();

            sToken = new StringTok(sToken.toString() + sTokenAdd.toString());

        }

        if (sToken.charLastAt() == 'e' || sToken.charLastAt() == 'E')    // Exponent
        {

            sTokenAdd = getToken();

            sToken = new StringTok(sToken.toString() + sTokenAdd.toString());

            if ((sTokenAdd.charAt(0) == '-' || sTokenAdd.charAt(0) == '+') && (m_nPosTok < getLength()) && !isDelimit(charAt(m_nPosTok))) {

                sTokenAdd = getToken();

                sToken = new StringTok(sToken.toString() + sTokenAdd.toString());

            }
        }
        return sToken;
    }

    public int getPosTok() {

        return m_nPosTok;

    }

    public void setString(String str) {

        m_str = str;

        initPosTok();

    }

    public void setString(char ch) {

        setString(String.valueOf(ch));

    }

    public void setString(StringTok str) {

        setString(str.toString());

    }

    public void setPosTok(int nPos) {

        m_nPosTok = nPos;

    }

    public void initPosTok() {

        setPosTok(0);

    }

    char charAt(int nPos) {

        return getAt(nPos);

    }

    char charLastAt() {

        return getLastAt();

    }

    public String toString() {

        return m_str;

    }

    public int atoi() {

        return Integer.parseInt(m_str);

    }

    public double atof() {

        return Double.parseDouble(m_str);

    }

    public static boolean isDelimit(char ch) {

        for (int i = 0; i < m_sDelimit.length(); i++) if (ch == m_sDelimit.charAt(i)) return true;

        return false;

    }

    public static boolean isWhite(char ch) {

        for (int i = 0; i < m_sWhite.length(); i++) if (ch == m_sWhite.charAt(i)) return true;

        return false;

    }
}