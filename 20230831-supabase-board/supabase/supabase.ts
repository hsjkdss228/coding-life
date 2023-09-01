import { createClient } from 'https://esm.sh/@supabase/supabase-js';

import { Database } from '../types/database.types.ts';

export const supabase = createClient<Database>(
  Deno.env.get('SUPABASE_URL'),
  Deno.env.get('SUPABASE_ANON_KEY'),
  {
    auth: {
      persistSession: false,
    },
  },
);
