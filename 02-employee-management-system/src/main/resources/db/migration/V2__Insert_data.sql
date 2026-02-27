INSERT INTO departments (name, created_at) VALUES
                                               ('Engineering', NOW()),
                                               ('Human Resources', NOW()),
                                               ('Finance', NOW()),
                                               ('Marketing', NOW()),
                                               ('Sales', NOW()),
                                               ('Operations', NOW()),
                                               ('Customer Support', NOW()),
                                               ('IT Services', NOW()),
                                               ('Research & Development', NOW()),
                                               ('Administration', NOW());

INSERT INTO employees (
    first_name,
    last_name,
    email,
    salary,
    department_id,
    is_active,
    hire_date,
    created_at,
    updated_at
) VALUES
      ('Arun', 'Kumar', 'arun.kumar@company.com', 55000.00, 1, true, '2023-01-10', NOW(), NOW()),
      ('Priya', 'Sharma', 'priya.sharma@company.com', 48000.00, 2, true, '2022-05-15', NOW(), NOW()),
      ('Rahul', 'Verma', 'rahul.verma@company.com', 72000.00, 3, true, '2021-08-01', NOW(), NOW()),
      ('Sneha', 'Reddy', 'sneha.reddy@company.com', 63000.00, 4, true, '2023-03-12', NOW(), NOW()),
      ('Vikram', 'Singh', 'vikram.singh@company.com', 51000.00, 5, false, '2020-11-20', NOW(), NOW()),
      ('Divya', 'Iyer', 'divya.iyer@company.com', 68000.00, 1, true, '2022-09-18', NOW(), NOW()),
      ('Karthik', 'Nair', 'karthik.nair@company.com', 47000.00, 6, true, '2023-07-25', NOW(), NOW()),
      ('Meera', 'Joshi', 'meera.joshi@company.com', 59000.00, 7, true, '2021-04-30', NOW(), NOW()),
      ('Suresh', 'Patel', 'suresh.patel@company.com', 75000.00, 8, true, '2019-12-05', NOW(), NOW()),
      ('Ananya', 'Gupta', 'ananya.gupta@company.com', 82000.00, 9, true, '2020-06-14', NOW(), NOW());
