#|
    	CSC461 Genealogy Program
    	filename: genealogy.lsp
    	usage: clisp -repl genealogy.lsp family.dat

	Author: Forrest Miller
	Due Date: 12/6/15

	Program Specifications: The genealogy.lsp program is run using a repl
	in clisp. You must provide a database file of people. After you enter
	the repl you can use any of the provided functions to gain information
	about people from your data file. The functions available are:
		parents/mothers/fathers
		children/daughters/sons
		siblings/sisters/brothers
		grandparents/grandfathers/grandmothers
		grandchildren/granddaughters/grandsons
		cousins/female-cousins/male-cousins
		uncles/aunts
		nieces/nephews
		ancestors/female-ancestors/male-ancestors
		decendants/female-decendants/male-decendants
	You call these functions by providing a name from you data file.
	Example: (parents 'forrest) -> This returns (PAUL JOAN)
|#

;==============================================================================

;define a structure for person with name gender parents and children
(defstruct person name gender parents children)

;set the global database to nil
(setf *database* nil)

(defun main (args)
"	(main args): no return
	The main function simply checks if a file was provided, and if it was
	then it calls the load-database function."
	(if (= (length args) 0)
		;(load-database (nth 0 args))
		(format t "ERROR: You must provide a data file.~%Usage: clisp -repl genealogy.lsp family.dat")
		(load-database (nth 0 args))
	)
)

(defun load-database (filename)
"	(load-database filename): fills database from file
	The load-database function opens the given file and reads in each line.
	It uses the parts of the line to create a person for the database."

	(setf fin (open filename))
    	(if (eql fin nil) (format t "ERROR: Could not open input file."))

	;read in each line of the file and return nil at the end of the file
	(do ((record (read fin nil) (read fin nil)))
		((null record) 'done) ;exit when record is nil
		
		;create new person structs and add to *database*
		(push (make-person
			:name (nth 0 record)
			:gender (nth 1 record)
			:parents (nth 2 record)
			:children (nth 3 record)) *database*)
	)

	(close fin) ;close the file
)

(defun flatten (lst)
"	(flatten lst): returns 'flattened' out list
	Taken from rosettacode.org/wiki/Flatten_a_list. This function flattens
	out nested lists."
	(cond ((null lst) nil)
	      ((atom lst) (list lst))
	      (t (append (flatten (first lst))
			 (flatten (rest lst))))
	)
)

(defun malefilter (relation)
"	(malefilter relation): returns name as list or nil
	The male filter takes a person name as a parameter. If the persons gender
    	is male then it returns that name as a list, else returns nil."

	(if (equal (gender relation) 'male) (list relation) nil)
)

(defun femalefilter (relation)
"	(femalefilter relation): returns name as list or nil
	The female filter takes a person name as a parameter. If the persons
    	gender is female then it returns that name as a list, else returns nil."

 	(if (equal (gender relation) 'female) (list relation) nil)
)

(defun gender (name)
"	(gender name): retuns gender
	The gender function is used by the gender filters and finds the person
	struct in the database by the name, and returns the gender."

	(person-gender (find name *database* :key 'person-name))
)

(defun parents (name)
"	(parents name): returns list of parents
	The parents function takes a persons name as a parameter. It then goes
	to the database and returns the persons parents."

	(person-parents (find name *database* :key 'person-name))
)

(defun mothers (name)
"	(mothers name): returns list of mothers
	The mothers function takes a persons name as a parameter. It then calls
	the parents function using the persons name. Finally, it passes the parent
	list to the femalefilter function and returns the result."

	(apply #'append (mapcar #'femalefilter (parents name)))
)

(defun fathers (name)
"	(fathers name): returns list of fathers
	The fathers function takes a persons name as a parameter. It then calls
	the parents function using the persons name. Finally, it passes the parent
	list to the malefilter function and returns the result."

	(apply #'append (mapcar #'malefilter (parents name)))
)

(defun children (name)
"	(children name): returns list of children
	The children function takes a persons name as a parameter. It then goes
	to the database and returns the persons children."

	(person-children (find name *database* :key 'person-name))
)

(defun daughters (name)
"	(daughters name): returns list of daughters
	The daughters function takes a persons name as a parameter. It then calls
	the children function using the persons name. Finally, it passes the child
	list to the femalefilter function and returns the result."

	(apply #'append (mapcar #'femalefilter (children name)))
)

(defun sons (name)
"	(sons name): returns list of sons
	The sons function takes a persons name as a parameter. It then calls
	the children function using the persons name. Finally, it passes the child
	list to the malefilter function and returns the result."

	(apply #'append (mapcar #'malefilter (children name)))
)

(defun siblings (name)
"	(siblings name): returns list of siblings
	The siblings function takes a persons name as a parameter. It then gets
	the parents of name and mapcars children onto that list. Finally, it 
	removes the duplicates and name."

	(remove name (remove-duplicates (apply #'append (mapcar #'children (parents name)))))
)

(defun sisters (name)
"	(sisters name): returns list of sisters
	The sisters function takes a persons name as a parameter. It then calls
	the siblings function using the persons name. Finally, it passes the sibling
	list to the femalefilter function and returns the result."

	(apply #'append (mapcar #'femalefilter (siblings name)))
)

(defun brothers (name)
"	(brothers name): returns list of brothers
	The brothers function takes a persons name as a parameter. It then calls
	the siblings function using the persons name. Finally, it passes the sibling
	list to the malefilter function and returns the result."

	(apply #'append (mapcar #'malefilter (siblings name)))
)

(defun grandparents (name)
"	(grandparents name): returns list of grandparents
	The grandparents function takes a persons name as a parameter. It then
	gets the parents of name and mapcars parents onto that list."

	(apply #'append (mapcar #'parents (parents name)))
)

(defun grandfathers (name)
"	(grandfathers name): returns list of grandfathers
	The grandfathers function takes a persons name as a parameter. It then calls
	the grandparents function using the persons name. Finally, it passes the
	grandparent list to the malefilter function and returns the result."

	(apply #'append (mapcar #'malefilter (grandparents name)))
)

(defun grandmothers (name)
"	(grandmothers name): returns list of grandmothers
	The grandmothers function takes a persons name as a parameter. It then calls
	the grandparents function using the persons name. Finally, it passes the
	grandparent list to the femalefilter function and returns the result."

	(apply #'append (mapcar #'femalefilter (grandparents name)))
)

(defun grandchildren (name)
"	(grandchildren name): returns list of grandchildren
	The grandchildren function takes a persons name as a parameter. It then
	gets the children of name and mapcars children onto that list."

	(apply #'append (mapcar #'children (children name)))
)

(defun grandsons (name)
"	(grandsons name): returns list of grandsons
	The grandsons function takes a persons name as a parameter. It then calls
	the grandchildren function using the persons name. Finally, it passes the
	grandchild list to the malefilter function and returns the result."

	(apply #'append (mapcar #'malefilter (grandchildren name)))
)

(defun granddaughters (name)
"	(granddaughters name): returns list of granddaughters
	The granddaughters function takes a persons name as a parameter. It then calls
	the grandchildren function using the persons name. Finally, it passes the
	grandchild list to the femalefilter function and returns the result."

	(apply #'append (mapcar #'femalefilter (grandchildren name)))
)

(defun cousins (name)
"	(cousins name): returns list of cousins
	The cousins function takes a persons name as a parameter. It then
	calls aunts and uncles with name and gets the children of the returned
	lists."

	(remove-duplicates (flatten (apply #'append (mapcar #'children (uncles name)) (mapcar #'children (aunts name)))))
)

(defun male-cousins (name)
"	(male-cousins name): returns list of male cousins
	The male-cousins function takes a persons name as a parameter. It then calls
	the cousins function using the persons name. Finally, it passes the cousin
	list to the malefilter function and returns the result."

	(apply #'append (mapcar #'malefilter (cousins name)))
)

(defun female-cousins (name)
"	(female-cousins name): returns list of female cousins
	The female-cousins function takes a persons name as a parameter. It then calls
	the cousins function using the persons name. Finally, it passes the cousin
	list to the femalefilter function and returns the result."

	(apply #'append (mapcar #'femalefilter (cousins name)))
)

(defun ancestors (name)
"	(ancestors name): returns list of ancestors
	The ancestors function takes a persons name as a parameter. It then
	appends the parents of name and the mapcar of ancestors of parents
	of name."

	(flatten (apply #'append (parents name) (mapcar #'ancestors (parents name))))	
)

(defun male-ancestors (name)
"	(male-ancestors name): returns list of male ancestors
	The male-ancestors function takes a persons name as a parameter. It then calls
	the ancestors function using the persons name. Finally, it passes the ancestor
	list to the malefilter function and returns the result."

	(apply #'append (mapcar #'malefilter (ancestors name)))
)

(defun female-ancestors (name)
"	(female-ancestors name): returns list of female ancestors
	The female-ancestors function takes a persons name as a parameter. It then calls
	the ancestors function using the persons name. Finally, it passes the ancestor
	list to the femalefilter function and returns the result."

	(apply #'append (mapcar #'femalefilter (ancestors name)))
)

(defun descendants (name)
"	(descendants name): returns list of ancestors
	The descendants function takes a persons name as a parameter. It then
	appends the children of name and the mapcar of descendants of children
	of name."

	(apply #'append (children name) (mapcar #'descendants (children name)))
)

(defun male-descendants (name)
"	(male-descendants name): returns list of male ancestors
	The male-descendants function takes a persons name as a parameter. It then calls
	the descendants function using the persons name. Finally, it passes the descendant
	list to the malefilter function and returns the result."

	(apply #'append (mapcar #'malefilter (descendants name)))
)

(defun female-descendants (name)
"	(female-descendants name): returns list of female ancestors
	The female-descendants function takes a persons name as a parameter. It then calls
	the descendants function using the persons name. Finally, it passes the descendant
	list to the femalefilter function and returns the result."

	(apply #'append (mapcar #'femalefilter (descendants name)))
)

(defun uncles (name)
"	(uncles name): returns list of uncles
	The uncles function gets the parents of name and then gets their siblings.
	It then gets the parents, removes duplicates and applys the male filter."

	(apply #'append (mapcar #'malefilter (remove-duplicates (apply #'append (mapcar #'parents (apply #'append (mapcar #'children (apply #'append (mapcar #'siblings (parents name))))))))))
)

(defun aunts (name)
"	(aunts name): returns list of aunts
	The aunts function gets the parents of name and then gets their siblings.
	It then gets the parents, removes duplicates and applys the female filter."

	(apply #'append (mapcar #'femalefilter (remove-duplicates (apply #'append (mapcar #'parents (apply #'append (mapcar #'children (apply #'append (mapcar #'siblings (parents name))))))))))
)

(defun nieces (name)
"	(nieces name): returns list of nieces
	The nieces function gets the siblings of name and then gets their children.
	Finally, it maps the femalefilter function onto the current list."

	(apply #'append (mapcar #'femalefilter (apply #'append (mapcar #'children (siblings name)))))
)

(defun nephews (name)
"	(nephews name): returns list of nephews
	The nephews function gets the siblings of name and then gets their children.
	Finally, it maps the malefilter function onto the current list."

	(apply #'append (mapcar #'malefilter (apply #'append (mapcar #'children (siblings name)))))
)

(main *ARGS*) ;call main to get filename and load database
