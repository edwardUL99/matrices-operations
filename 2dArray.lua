local R = 4
local C = 4
local col = 1
local m = {}

local function create()
	for i = 1,R do
		m[i] = {}
		for j = 1, C do
			m[i][j] = 0
		end
	end
end

local function newArray(height, width)
	local array = {}
	for i = 1,height do
		array[i] = {}
		for j = 1, width do
			array[i][j] = 0
		end
	end
	return array
end

local function fill(matrix)
    for row = 1,#matrix do
        for col = 1,#matrix[1]do
            matrix[row][col] = math.random(1,10)
         end
    end
end

local function toString(a)
    local contents = "["
        for i = 1,#a - 1 do
            contents = contents .. tostring(a[i]) .. ","
        end
        contents = contents .. tostring(a[#a]).. "]"
    return contents
end

local function deepToString(array)
    local a = ""
    if #array == 0 then
        a = "[]"
    else 
        a = "["
        for row = 1,#array - 1 do
			a = a .. toString(array[row]) .. ","
			
        end
		a = a .. toString(array[#array]) .. "]"
    end
    return a
end

local function Display(arrayIn)
	for row = 1, #arrayIn do
		print("Row" .. " " .. tostring(row))
		for column = 1, #arrayIn[1] do 
			print(arrayIn[row][column])
		end
	end
end

local function matrixMultiplication(matrix1, matrix2)
	local product
	if (#matrix1[1] == #matrix2) then
		product = newArray(#matrix1, #matrix2[1])
		for i = 1,#matrix1
		do
			for j = 1, #matrix2[1] do
				for k = 1, #matrix1[1] do
					product[i][j] = product[i][j] + matrix1[i][k] * matrix2[k][j]
                end
			end
		end
	else 
		product = nil
	end
	return product
end

local function matrixTranspose(arr)
	local transpose = newArray(#arr[1], #arr)
	for row = 1, #transpose do
		for col = 1, #transpose[1] do
			transpose[row][col] = arr[col][row]
		end
	end
	return transpose
end
	

create()
fill(m)
--print(toString(m[R]))
print(deepToString(m))
fill(m)
print(deepToString(m))
Display(m)

local array1 = {{1, 2, 3, 4}, {5, 6, 7, 8}}
local array2 = {{3, 4}, {1, 2}, {5, 9}, {2, 6}}
Display(matrixMultiplication(array1, array2))
print(deepToString(matrixTranspose(array1)))



        
