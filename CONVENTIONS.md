# Nutmeg Coding Conventions

-----

## Variable Names & Declarations

- Names MUST begin with a lower case character
- Names CAN be mixed-case after the first character
- The fist letter of any word in a name MUST be in all caps;
- Names MUST be self-Describing without any documentation
-  function parameter Variables MUST be prefixed with _
- Names MUST NOT contain a _ inside EXCEPT in the case of a function parameter variable, in which case the next character MUST be Capitalised OR in the case of a CONSTANT in which word MUST be separated be an _
- A Constant MUST 

### Valid:

- name
- windowID
- width
- height
- dogName
- (local) _Name
- (Constant) MAX_STACK_SIZE

### Invalid:

- x
- WindowID
- dog_Name
- (local) width
- (constant) maxstacksize

-------------

## Function Names

- Functions MUST start with a capital letter

### Valid

- Create(int _width, int _height)

### Invalid:

- create(int WIDTH, int HEIGHT)