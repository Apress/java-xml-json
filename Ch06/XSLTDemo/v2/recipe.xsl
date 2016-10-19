<?xml version="1.0"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/recipe">
<html>
   <head>
      <title>Recipes</title>
   </head>

   <body>
      <h2>
         <xsl:value-of select="normalize-space(title)"/>
      </h2>

      <h3>Ingredients</h3>

      <ul>
      <xsl:for-each select="ingredients/ingredient">
        <li>
           <xsl:value-of select="normalize-space(text())"/>
           <xsl:if test="@qty"> (<xsl:value-of select="@qty"/>)</xsl:if>
        </li>
      </xsl:for-each>
      </ul>

      <h3>Instructions</h3>

      <xsl:value-of select="normalize-space(instructions)"/>
   </body>
</html>
</xsl:template>
</xsl:stylesheet>
