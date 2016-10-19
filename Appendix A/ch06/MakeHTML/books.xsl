<?xml version="1.0"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/books">
<html>
<head>
<title>Books</title>
</head>
<body>
<xsl:for-each select="book">
<h2>
<xsl:value-of select="normalize-space(title/text())"/>
</h2>
ISBN: <xsl:value-of select="@isbn"/><br/>
Publication Year: <xsl:value-of select="@pubyear"/><br/>
<br/><xsl:text>
</xsl:text>
<xsl:for-each select="author">
<xsl:value-of select="normalize-space(text())"/><br/><xsl:text>
</xsl:text>
</xsl:for-each>
</xsl:for-each>
</body>
</html>
</xsl:template>
</xsl:stylesheet>
