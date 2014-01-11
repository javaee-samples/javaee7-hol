echo "Converting to HTML ..."
#asciidoctor -a toc -a numbered javaee7-hol.adoc
asciidoctor -v -a toc -a numbered javaee7-hol.adoc
echo "done"

#echo "Converting to DocBook ..."
#asciidoctor -b docbook -a toc -a numbered -d book javaee7-hol.adoc
#echo "done"

#echo "Converting to PDF ..."
#~/tools/asciidoctor-fopub/fopub javaee7-hol.xml
#echo "done"

